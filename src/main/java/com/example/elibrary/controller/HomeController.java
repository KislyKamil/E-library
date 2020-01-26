package com.example.elibrary.controller;

import com.example.elibrary.entity.Book;
import com.example.elibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;


@Controller
public class HomeController {


    private final BookRepository bookRepo;


    public HomeController(BookRepository bookRepo) {


        this.bookRepo = bookRepo;
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

    //TODO Organize communication with Entity and repository by Service.


    @RequestMapping(path = "/")
    @Autowired
    public ModelAndView index() {

        ArrayList<Book> b = new ArrayList<>();

        int size;
        int pageNumbers;


        b.addAll(bookRepo.findAll());

        size = b.size();

        pageNumbers = roundUp(size);

        ModelAndView model = new ModelAndView("index");
        model.addObject("books", b);
        //model.addObject("length", pageNumbers);

        return model;


    }

    @RequestMapping(path = "/{pageId}")
    @ResponseBody
    public ArrayList<Book> getBooks(@PathVariable("pageId") int pageId, ModelMap model) {

        ArrayList<Book> b = new ArrayList<>();
        ArrayList<Book> allBooks = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        allBooks.addAll(bookRepo.findAll());

        int index = (pageId * 5) - 4;


        if (pageId <= roundUp(allBooks.size())) {

            while (index <= (pageId * 5)) {
                ids.add(index);
                index++;
            }

        } else {
            // return "error";
        }

        b.addAll(bookRepo.findAllById(ids));

        model.addAttribute("pageId", pageId);
        model.addAttribute("books", b);

        return b;
    }


}
