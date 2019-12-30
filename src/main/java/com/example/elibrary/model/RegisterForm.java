package com.example.elibrary.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {

    private String login;
    private String password;
    private String email;
    private String type;

    /*

    public RegisterForm(String login, String password, String email, String type) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.type = type;
    }

  */
}
