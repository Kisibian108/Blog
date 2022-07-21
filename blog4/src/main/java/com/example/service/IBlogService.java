package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void delete(int id);

    List<Blog> searchByName(String keyword);

    Blog getBlog(int id);

}
