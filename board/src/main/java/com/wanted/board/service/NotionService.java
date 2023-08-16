package com.wanted.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanted.board.model.Member;
import com.wanted.board.model.Notion;
import com.wanted.board.repository.NotionRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class NotionService {
	
	private final NotionRepository notionRepository;

	
	@Transactional
	public void writeNotion(Notion notion, Member member) {
		notion.setMember(member);
		notionRepository.save(notion);
		
	}

	
	@Transactional
	public void deleteNotion(int id) {
		notionRepository.deleteById(id);
	}

	
	@Transactional
	public void updateNotion(int id, Notion requestNotion) {
		Notion notion = notionRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
				}); 
		notion.setTitle(requestNotion.getTitle());
		notion.setContent(requestNotion.getContent());
		
	}


	public Page<Notion> getNotionPage(Pageable pageable) {
        return notionRepository.findAll(pageable);
    }


	public Notion NotionId(int id) {
		return notionRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
				});
	}

}
