package com.example.demo1.board.controller;

import com.example.demo1.board.controller.dto.BoardCommandDtos.BoardCreateRequest;
import com.example.demo1.board.controller.dto.BoardCommandDtos.BoardCreateResponse;
import com.example.demo1.board.domain.Board;
import com.example.demo1.board.domain.BoardStatus;
import com.example.demo1.board.service.BoardCreateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController //<<< bean 등록
@RequiredArgsConstructor // final 또는 non-null인 것만 생성자 만들어 줌.
@RequestMapping("/boards")

public class BoardCommandApi {
    private final BoardCreateUseCase boardCreateUseCase; // usecase <<< 더 추상화계층이 높아서 사용.
    //여기 코드는 단 하나도 바꾸지 않고, 나중에 서비스를 교체할 수 있게 하기 위해서.(의존성 역전 원칙 DIP)
    //클래스를 바로 사용하면, 나중에 새로운 빈으로 갈아끼우거나 할 때 여기 와서 여기도 수정해야 함.
    // 인터페이스를 사용하면 -> 빈 갈아끼우는 건 스프링이 알아서 해 주니까 여기서 우리가 수정할 필요 X

    @PostMapping
   
    public BoardCreateResponse create(@RequestBody @Valid BoardCreateRequest dto) {
        Instant now = Instant.now();
        Board board = Board.builder()
                .title(dto.title())
                .content(dto.content())
                .status(BoardStatus.ACTIVE)
                .createdAt(now)
                .updatedAt(now)
                .build();

        var savedEntity = boardCreateUseCase.create(board);
        
        return BoardCreateResponse.builder()
                .board(savedEntity)
                .build();
    }

}
