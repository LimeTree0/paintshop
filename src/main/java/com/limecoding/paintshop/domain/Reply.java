package com.limecoding.paintshop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Reply {
    private Long id;
    private User author;
    private Long paintId;
    private String content;

}
