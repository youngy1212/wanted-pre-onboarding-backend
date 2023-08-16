package com.wanted.board.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.wanted.board.dto.ResponseDto;
import com.wanted.board.model.Member;
import com.wanted.board.model.Notion;
import com.wanted.board.service.NotionService;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public class NotionApiController {

	
	@Autowired
	private NotionService notionService;
	
	//게시글 생성
	@PostMapping("/notion")
	public ResponseDto<Integer> writeNotion(@RequestBody Notion notion,Member member) {
		notionService.writeNotion(notion, member);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	//게시글 삭제
	@DeleteMapping("/notion/{notion-id}")
	public ResponseDto<Integer> deleteNotion(@PathVariable int id){
		notionService.deleteNotion(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	//개시글 수정
	@PutMapping("/notion/{id}")
	public ResponseDto<Integer> updateNotion(@PathVariable int id, @RequestBody Notion notion){
		notionService.updateNotion(id, notion);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	//게시글 리스트 조회
	@GetMapping("/list")
    public ResponseDto<Page<Notion>> listNotion(Pageable pageable) {
        Page<Notion> notionPage = notionService.getNotionPage(pageable);
        return new ResponseDto<>(HttpStatus.OK.value(), notionPage);
    }
	
	
	//게시글 상세조회
	@GetMapping("/notion/{id}")
	 public ResponseDto<Notion> Notion(@PathVariable int id) {
		Notion notion = notionService.NotionId(id);
		return new ResponseDto<>(HttpStatus.OK.value(), notion);
    }
	

}
