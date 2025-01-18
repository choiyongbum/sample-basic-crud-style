package com.example.demo1.board.service;

import com.example.demo1.board.domain.Board;

public interface BoardCreateUseCase { //Service 인터페이스(그것이 세분화된 것뿐)
    Board create(Board board);
}
