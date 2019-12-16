package com.example.elibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @RequestMapping(path = "/register")
    @Autowired
    public String register(){

        return "register";
    }

    @RequestMapping(path = "/registerUser")
    @Autowired
    public void registerUser(){


    }
}