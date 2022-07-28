package com.example.service;

import com.example.model.Category;

import java.util.List;
import java.util.Set;

public interface ICategoryService {
    Set<Category> getAllCategory();

    Category findById(int id);

    void delete(int id);
}
