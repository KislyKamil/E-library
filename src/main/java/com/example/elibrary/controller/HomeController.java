package com.example.elibrary.controller;

import com.example.elibrary.entity.Book;
import com.example.elibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
public class HomeController {


    private final BookRepository book;

    public HomeController(BookRepository book) {

        this.book = book;
    }


    @RequestMapping(path = "/")
    @Autowired
    public ModelAndView index() {

        ArrayList<Book> b = new ArrayList<>();

        b.addAll(book.findAll());

        ModelAndView model = new ModelAndView("index");
        model.addObject("books", b);

        return model;


    }


}
