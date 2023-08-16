package com.wanted.board.controller.api;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wanted.board.dto.ResponseDto;
import com.wanted.board.model.Member;
import com.wanted.board.service.MemberService;

@RestController
public class MemberApiController {
	
	@Autowired
	private MemberService memberService;

	
	//회원가입
	@PostMapping("/member/users")
	public ResponseDto<Integer> save(@RequestBody Member member) {
			
		memberService.singin(member);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		
	}
	
//	//로그인
//	@PostMapping("/member/login")
//	public ResponseEntity<JWTToken> login(@RequestBody Map<String, String> loninForm ){
//	
//	}
	


}
