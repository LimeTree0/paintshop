package com.limecoding.paintshop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Paint {
    private Long id;
    private String name;
    private User author;
}
