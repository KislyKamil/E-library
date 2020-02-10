package com.example.elibrary.service;


import com.example.elibrary.entity.Book;
import com.example.elibrary.entity.User;
import com.example.elibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(int id){

        return userRepository.findById(id).get();
    }

    public List<User> getUserByName(String name){


        return userRepository.findByLoginLike(name);
    }

    public void addUser(User user){

        userRepository.save(user);
    }

    public void updateUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User userToUpdate = userRepository.findById(user.getUserId()).get();
        userToUpdate.setLogin(user.getLogin());
        userToUpdate.setPassword(encoder.encode(user.getPassword()));
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setType(user.getType());

        userRepository.save(userToUpdate);
    }


    public List<User> listUsers(){

         List<User> users = new ArrayList<>(userRepository.findAll());

         return users;
    }

    public void deleteUser(int id){

        userRepository.deleteById(id);

    }

    public List<User> findUser(String name){
        List<User> user = new ArrayList<>();

        user.addAll(userRepository.findByLoginLike(name));

        return user;

    }

}
