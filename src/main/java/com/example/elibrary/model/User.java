package com.example.elibrary.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.RequestContextFilter;


@Component
@Scope("session")
public class User{


    private String userName;
    private String userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

/*
    public User(String name, String role) {
        this.userName = name;
        this.userRole = role;
    }

 */
}
