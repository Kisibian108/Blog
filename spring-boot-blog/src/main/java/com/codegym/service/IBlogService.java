package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

//    void delete(int id);

    Blog findById(int id);

    Blog getBlog(int id);

}
