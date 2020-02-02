package com.example.elibrary.controller;

import com.example.elibrary.entity.User;
import com.example.elibrary.service.UserService;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService){
        this.userService = userService;
    }



    @RequestMapping(path = "/adminPanel")
    public String mainPage(){

        return "adminPanel";
    }

    @RequestMapping(path = "/adminPanel/find")
    @ResponseBody
    public List<User> getUser(@RequestParam("query") String query){

        List<User> listUser = new ArrayList<>();
        listUser.addAll( userService.findUser(query));

        return listUser ;
    }


}
