package com.example.elibrary.controller;

import com.example.elibrary.model.LoginForm;
import com.example.elibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController{

   // @Autowired
    private User user;

    @RequestMapping(path = "/login")
    @Autowired
    public ModelAndView login() {

        return new ModelAndView("login", "login", new LoginForm());

    }


    @RequestMapping(path = "/loginUser", method = RequestMethod.POST)
    @Scope("session")
    public String loginUser(@ModelAttribute("login") LoginForm user, HttpSession session, ModelMap model) {

        final String role;

        try {
            if (user.getPassword().isEmpty()) {
                return "error";
            }

        } catch (Exception e) {


        }
        model.addAttribute("loginName", user.getLogin());
        model.addAttribute("password", user.getPassword());

        if (user.getLogin().equals("Admin")) {
            role = "Admin";
        }else{
            role = "standard user";
        }

        setUser(user.getLogin(), role);
        model.addAttribute("role",role);
        session.setAttribute("who", user.getLogin());


        return "Success";

    }

    public void setUser(String name, String role) {

        //this.user = new User (name, role);
        this.user = new User();
        user.setUserName(name);
        user.setUserRole(role);

    }


}
