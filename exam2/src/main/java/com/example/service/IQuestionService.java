package com.example.service;

import com.example.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IQuestionService {

    Page<Question> findAllQuestion(Pageable pageable, String keyword);

    List<Question> findAll();

    void save(Question question);
//
//    void insert(Question question);

    void delete(int id);

    Optional<Question> findById(int id);

    List<Question> findQuestionByTitle(String keyword);
}
