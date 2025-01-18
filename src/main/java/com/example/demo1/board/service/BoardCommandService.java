package com.example.demo1.board.service;

import com.example.demo1.board.domain.Board;
import com.example.demo1.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardCommandService implements BoardCreateUseCase /* 서비스 인터페이스 */{

    private final BoardRepository boardRepository;

    public BoardCommandService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board create(Board board) {
        //함수의 왼쪽과 오른쪽
        //왼쪽 : 반환 타입
        // 오른쪽 : 파라미터 목록
        var savedEntity = boardRepository.save(board); // id가있는엔티티 = repository.save(id가없는엔티티);
        return boardRepository.save(board);
    }
}
