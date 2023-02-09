package com.example.validate_from_register.service;

import com.example.validate_from_register.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
