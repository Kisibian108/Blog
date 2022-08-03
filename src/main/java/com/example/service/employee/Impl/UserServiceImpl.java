package com.example.service.employee.Impl;

import com.example.model.employee.User;
import com.example.repository.employee.IUserRepository;
import com.example.service.employee.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
