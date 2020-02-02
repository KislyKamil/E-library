package com.example.elibrary.core;


import com.example.elibrary.repository.BookRepository;
import com.example.elibrary.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public DataBaseLoader(UserRepository userRepository, BookRepository bookRepository) {

        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Are you working??");



    }
}
