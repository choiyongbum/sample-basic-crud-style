package com.example.demo1.board.controller.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.example.demo1.board.domain.Board;
import lombok.Builder;

public final class BoardCommandDtos { //final 상속 X 

    private BoardCommandDtos() { //인스턴스 상속 X
        
    }

    @Builder
    public record BoardCreateRequest(
            @NotBlank(message = "제목을 입력하십시오.") // null, empty "", blank " "
            @Size(min = 3, message = "제목은 세 글자 이상 입력하세요.")
            @Size(max = 50, message = "제목은 최대 50글자입니다.")
            String title,

            @NotBlank(message = "본문을 입력하십시오.")
            @Size(min = 3, message = "본문은 세 글자 이상 입력하세요.")
            String content) {
        
    } 
    
    @Builder
    public record BoardCreateResponse(Board board) {
        
    }
}
