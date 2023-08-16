package com.wanted.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wanted.board.model.Notion;

public interface NotionRepository extends JpaRepository<Notion, Integer>{

}

