package com.example.elibrary.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ModifyUser {

    private String login;
    private String oldPass;
    private String newPass;
    private String email;
}
