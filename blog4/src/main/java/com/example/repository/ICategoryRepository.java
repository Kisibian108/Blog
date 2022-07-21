package com.example.repository;

import com.example.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = " select * from category ", nativeQuery = true)
    Set<Category> getAllCategory();
}
