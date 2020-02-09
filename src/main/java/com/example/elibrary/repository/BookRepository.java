package com.example.elibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.example.elibrary.entity.Book;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

   // @Query("SELECT name FROM Book  WHERE name LIKE '%name%' ")
    //List<Book> findByNameLike (@Param("name") String name);

    List<Book> findByAuthorContains(String name);

    List<Book> findByNameContains(String name);




}