package com.example.dao;

import com.example.domain.User;

import java.util.List;

public class UserDAOImpl implements UserDAO{

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
