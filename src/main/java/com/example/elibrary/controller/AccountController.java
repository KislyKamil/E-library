package com.example.elibrary.controller;

import com.example.elibrary.entity.Order;
import com.example.elibrary.entity.User;
import com.example.elibrary.model.order;
import com.example.elibrary.service.OrderService;
import com.example.elibrary.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AccountController {

    private final UserService userService;
    private final OrderService orderService;

    public AccountController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @RequestMapping(path = "/account")
    public String mainPage(HttpSession session, Model model){

        ArrayList<User> user = new ArrayList<>();
        ArrayList<Order> order = new ArrayList<>();

        session.getAttribute("userId");
        System.out.println(  session.getAttribute("userId"));

        user.add(userService.getUser((Integer) session.getAttribute("userId")));
        order.addAll(orderService.showUserOrder((Integer) session.getAttribute("userId")));

        System.out.println(order);

        model.addAttribute("users", user);
        model.addAttribute("orders", order);


        return "userPanel";
    }


}
