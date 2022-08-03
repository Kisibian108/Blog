package com.example.repository.employee;

import com.example.model.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
