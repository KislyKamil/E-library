package com.example.elibrary.controller;

import com.example.elibrary.model.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @RequestMapping(path = "/login")
    @Autowired
    public ModelAndView login() {


        return new ModelAndView("login", "login", new LoginForm());

    }

    @RequestMapping(path = "/loginUser", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("login") LoginForm user, ModelMap model) {

        try {
            if (user.getPassword().isEmpty()) {
                return "error";
            }

        } catch (Exception e) {


        }
        model.addAttribute("loginName", user.getLogin());
        model.addAttribute("password", user.getPassword());

        return "index";

    }

}
