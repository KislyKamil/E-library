package com.example.elibrary.controller;
import com.example.elibrary.entity.User;
import com.example.elibrary.model.RegisterForm;
import com.example.elibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {

        this.userService = userService;

    }

    @RequestMapping(path = "/register")
    @Autowired
    public ModelAndView register() {

        ModelAndView registerView = new ModelAndView("register", "registerForm", new RegisterForm());

        return registerView;
    }





    @RequestMapping(path = "/registerUser")
    public String registerUser(@ModelAttribute("registerForm") RegisterForm form) {


        User user = new User();
        user.setLogin(form.getLogin());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        user.setType("user");


        userService.addUser(user);

        return "Success";

    }


}