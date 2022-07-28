package com.example.service;

import com.example.model.Category;
import com.example.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryImpl implements ICategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Set<Category> getAllCategory() {
        return categoryRepository.getAllCategory();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
