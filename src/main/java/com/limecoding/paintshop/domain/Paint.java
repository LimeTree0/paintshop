package com.limecoding.paintshop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Paint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;
    private String subscribe;
    private String author;
    private String filePath;
}
