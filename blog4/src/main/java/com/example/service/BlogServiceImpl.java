package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
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
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(int id) {
            blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> searchByName(String keyword) {
        return blogRepository.searchByName(keyword);
    }

    public Blog getBlog(int id) {
        return blogRepository.getBlog(id);
    }
}
