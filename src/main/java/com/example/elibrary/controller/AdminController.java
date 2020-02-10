package com.example.elibrary.controller;

import com.example.elibrary.entity.Book;
import com.example.elibrary.entity.Order;
import com.example.elibrary.entity.User;
import com.example.elibrary.service.BookService;
import com.example.elibrary.service.OrderService;
import com.example.elibrary.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final BookService bookService;
    private final OrderService orderService;

    public AdminController(UserService userService, BookService bookService, OrderService orderService){

        this.userService = userService;
        this.bookService = bookService;
        this.orderService = orderService;
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

    @GetMapping(path = "/adminPanel/addBook")
    public void addBook(@RequestParam("name")String name, @RequestParam("author") String author, Model model){

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setStatus(true);
        book.setBookId((bookService.listBooks().size())+1);



            bookService.addBook(book);


            model.addAttribute("msg", "book added successfully");

    }

    @RequestMapping(path = "/adminPanel/findOrders")
    @ResponseBody
    public List<Order> getUser(@RequestParam("query") int query){

        List<Order> orders = new ArrayList<>();


        orders.addAll(orderService.showUserOrder(query));

        return orders ;
    }

}
