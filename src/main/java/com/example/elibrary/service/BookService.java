package com.example.elibrary.service;
import com.example.elibrary.entity.Book;
import com.example.elibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBook(int id){

        return bookRepository.findById(id).get();
    }

    public void addBook(Book book){

        bookRepository.save(book);
    }

    public void deleteBook(int id){

        bookRepository.deleteById(id);
    }

    public List<Book> listBooks(){

        List<Book> books = new ArrayList<>();
        books.addAll(bookRepository.findAll());


        return books;
    }

    public List<Book> ListById(List<Integer> ids){

        List<Book> selectedBooks = new ArrayList<>();
        selectedBooks.addAll(bookRepository.findAllById(ids));

        return selectedBooks;
    }
    public void updateBook(Book book){

        Book bookToUpdate = bookRepository.findById(book.getBookId()).get();
        bookToUpdate.setName(book.getName());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setStatus(book.getStatus());

        bookRepository.save(bookToUpdate);
    }

    public List<Book> ListBooksByContent(String param){


        List<Book> nameList = new ArrayList<>();
        List<Book> authorList = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();

        nameList.addAll(bookRepository.findByNameContains(param));
        System.out.println(nameList);
        authorList.addAll((bookRepository.findByAuthorContains(param)));
        System.out.println(authorList);


        for(Book i: authorList) {

            bookList.add(i);
        }
        for(Book i: nameList) {

            bookList.add(i);
        }
        Set<Book> set = new HashSet<>(bookList);
        bookList.clear();
        bookList.addAll(set);

        return bookList;
    }

    }


