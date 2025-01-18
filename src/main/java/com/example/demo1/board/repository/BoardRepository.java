package com.example.demo1.board.repository;

import com.example.demo1.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    
}
