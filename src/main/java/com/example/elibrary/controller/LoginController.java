package com.example.elibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

@RequestMapping(path = "/login")
@Autowired
public String login(){

        return "login";
        }
}
