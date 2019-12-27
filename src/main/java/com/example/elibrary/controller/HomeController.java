package com.example.elibrary.controller;

import com.example.elibrary.entity.Book;
import com.example.elibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final BookRepository book;

    public HomeController(BookRepository book) {

        this.book = book;

    }

    @RequestMapping(path = "/")
    @Autowired
    public String index() {



        return "index";
    }


}
