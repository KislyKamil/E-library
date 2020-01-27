package com.example.elibrary.service;
import com.example.elibrary.entity.Book;
import com.example.elibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
