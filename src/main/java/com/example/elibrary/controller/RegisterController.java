package com.example.elibrary.controller;

import com.example.elibrary.entity.Users;
import com.example.elibrary.model.RegisterForm;
import com.example.elibrary.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    private final UsersRepository users;

    public RegisterController(UsersRepository users) {
        this.users = users;
    }

    @RequestMapping(path = "/register")
    @Autowired
    public ModelAndView register() {

        ModelAndView registerView = new ModelAndView("register", "registerForm", new RegisterForm());

        return registerView;
    }

    @RequestMapping(path = "/registerUser")
    public String registerUser(@ModelAttribute("registerForm") RegisterForm form) {

        Users user = new Users();
        user.setLogin(form.getLogin());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        user.setType("user");

        users.save(user);

        return "registerSuccess";

    }


}