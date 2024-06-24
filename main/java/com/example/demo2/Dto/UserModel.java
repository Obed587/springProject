package com.example.demo2.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String role;

    private String matchingPassword;

    public UserModel(Long id, String firstname, String lastname, String email, String role, String password) {
    }
}
