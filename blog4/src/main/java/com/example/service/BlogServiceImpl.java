package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

/*    @Override
    public void update(Blog blog) {
        blogRepository.update( blog.getName(), blog.getId());
    }*/

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(int id) {
            blogRepository.delete(id);
    }

    @Override
    public List<Blog> searchByName(String keyword) {
        return blogRepository.searchByName(keyword);
    }

    public Blog getBlog(int id) {
        return blogRepository.getBlog(id);
    }
}
