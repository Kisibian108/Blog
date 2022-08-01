package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    Page<Blog> getAllBlog(Pageable pageable, String keyword);

    Blog save(Blog blog);

    Optional<Blog> findById(int id);

    void delete(int id);

    List<Blog> searchByName(String keyword);

    List<Blog> searchByAuthor(String name);

    Blog getBlog(int id);

}
