package com.example.dao;

import com.example.domain.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    User findOne(Long id);

    boolean save(User user);

    boolean delete(Long id);


}
