package com.example.elibrary.core;


import com.example.elibrary.repository.BookRepository;
import com.example.elibrary.repository.UsersRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements ApplicationRunner {

    private final UsersRepository userRepository;
    private final BookRepository bookRepository;

    public DataBaseLoader(UsersRepository userRepository, BookRepository bookRepository) {

        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Are you working??");



    }
}
