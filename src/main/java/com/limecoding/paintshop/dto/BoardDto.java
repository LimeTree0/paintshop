package com.limecoding.paintshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    private Long id;
    private String author;
    private String title;
    private String content;
}
