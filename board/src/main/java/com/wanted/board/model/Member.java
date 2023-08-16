package com.wanted.board.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; 
	
	@Size(min = 8, message = "비밀번호는 8자 이상이어야 합니다")
	@Column(nullable = false, length = 100) 
	private String password;
	
	
	@Pattern(regexp = ".*@.*", message = "올바른 이메일 형식을 입력해주세요")
	@Column(nullable = false, length = 50)
	private String email; 

}
