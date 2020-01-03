package com.example.elibrary.controller;

import com.example.elibrary.entity.Book;
import com.example.elibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
public class HomeController {


    private final BookRepository book;

    public HomeController(BookRepository book) {

        this.book = book;
    }

    public int roundUp(int value) {

        float toFloat = value;
        float size = toFloat / 5;

        int sizeInt = value / 5;


        if (size % sizeInt != 0) {
            sizeInt = sizeInt + 1;
        }

        return sizeInt;
    }


    @RequestMapping(path = "/")
    @Autowired
    public ModelAndView index() {

        ArrayList<Book> b = new ArrayList<>();
        int size;
        int pageNumbers;


        b.addAll(book.findAll());

        size = b.size();

        pageNumbers = roundUp(size);

        ModelAndView model = new ModelAndView("index");
        model.addObject("books", b);
        model.addObject("length", pageNumbers);

        return model;


    }

    @RequestMapping(path = "/{pageId}")
    public ModelAndView pageView(@PathVariable("pageId") int pageId) {

        ArrayList<Book> b = new ArrayList<>();

        b.addAll(book.findAll());

        b.size();

        return new ModelAndView();
    }


}
