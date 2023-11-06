package com.limecoding.paintshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class PaintResponseDto {
    private String title;
    private String subscribe;
    private int price;
    private String author;
    private String filePath;
}
