package com.limecoding.paintshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JoinDto {

    private String memberId;
    private String password;

    public JoinDto(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }
}
