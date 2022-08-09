package com.example.mybatisplus.model;

import lombok.*;

import java.util.Date;

//@Setter
//@Getter
////@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//@ToString
////@EqualsAndHashCode
////@EqualsAndHashCode(exclude = {"id", "name"})
//@EqualsAndHashCode(of = {"id", "name"})
@Data
@Builder
public class User {

    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.NONE)
    private int id;

    @NonNull
    private final String name;

    private String email;

    private String phone;

    private String pwd;

    private Date createDate;

    public void login(@NonNull String pwd) {
        System.out.println(pwd);
    }
}
