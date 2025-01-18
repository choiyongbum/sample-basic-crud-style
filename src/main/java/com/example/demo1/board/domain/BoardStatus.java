package com.example.demo1.board.domain;


//선택지가 있는 구조에 사용하는 데이터 타입
// enum Season {SPRING, SUMMER, AUTUMN, WINTER }
// enum Color { RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, BLACK, WHITE}
// enum Algorithm {SHA1, SHA256, ...}
public enum BoardStatus {
    /** 
     * 대기 
     */
   
    PENDING,
    /** 
     * 활성화 
     */
    
    ACTIVE,
    /**
     * 제한됨 
     */
   
    SUSPENDED,
    /**
     * 삭제 
     */
    
    REMOVE
}
