package com.example.service;

import com.example.dto.UserDto;
import com.example.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);
}
