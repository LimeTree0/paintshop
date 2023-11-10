package com.limecoding.paintshop.dto;

import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;

    public BoardResponseDto(Long id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
