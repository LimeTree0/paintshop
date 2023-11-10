package com.limecoding.paintshop.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String author;
    private String title;
    private String content;

    public BoardRequestDto(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
