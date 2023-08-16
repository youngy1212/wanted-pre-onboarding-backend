package com.wanted.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wanted.board.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	//Optional<Member> findByEmail(String email);
	
}
