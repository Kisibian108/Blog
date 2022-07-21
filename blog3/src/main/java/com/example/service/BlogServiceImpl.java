package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

//    @Override
//    public void delete(int id) {
//            blogRepository.delete(id);
//    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog getBlog(int id) {
        return null;
    }

    @Override
    public List<Blog> findByName(String keyword) {
        return blogRepository.searchByName(keyword);
    }
}
