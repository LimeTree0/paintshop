package com.limecoding.paintshop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ShopUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private Role role;
    private String memberId;
    private String password;
//    private String name;
//    private String nickname;
//    private String email;
//    private String phone;


    public User(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }
}
