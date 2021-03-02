package com.example.service;

import com.example.dao.UserDAO;
import com.example.domain.User;

import java.time.Instant;
import java.util.List;

//Test Doubles

/**
 * DUMMY:
 */
public class UserService {

    private UserDAO userDAO; //dependencia

    public List<User> recuperateUsers(){
        //...

        List<User> users= userDAO.findAll();

        //..

        return users;
    }

    public User findOne(Long id){

        //...
        User user =  userDAO.findOne(id);

        user.setAccessDate(Instant.now());

        //code...

        return user;

    }



}
