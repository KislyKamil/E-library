package com.example.elibrary.service;

import com.example.elibrary.entity.Users;
import com.example.elibrary.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public Users getUser(int id){

        return usersRepository.findById(id).get();
    }

    public void addUser(Users user){

        usersRepository.save(user);

    }

    public List<Users> listUsers(){

         List<Users> users = new ArrayList<>(usersRepository.findAll());

         return users;
    }

    public void deleteUser(int id){

        usersRepository.deleteById(id);

    }

}
