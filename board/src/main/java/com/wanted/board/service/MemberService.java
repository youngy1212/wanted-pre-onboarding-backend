package com.wanted.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanted.board.model.Member;
import com.wanted.board.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public int singin(Member member) {
		String rawPassword = member.getPassword(); 
		String encPassword = encoder.encode(rawPassword); 
		member.setPassword(encPassword);
		
		try {
			memberRepository.save(member);
			return 1;
		} catch (Exception e) {
			return -1;
		}
		
	}

	
//	@Transactional(readOnly = true)
//	public Member login(Member member) {
//		
//		return memberRepository.findByMemberemailAndPassword(member.getEmail(), member.getPassword());
//		
//	}


//
//	@Transactional(readOnly = true)
//	public User 회원찾기(String username) {
//		User user = userRepository.findByUsername(username).orElseGet(()->{
//			return new User();
//		});
//		return user;
//	}
}
