package com.example.service.Impl;

import com.example.model.Question;
import com.example.repository.IQuestionRepository;
import com.example.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    IQuestionRepository questionRepository;
    @Override
    public Page<Question> findAllQuestion(Pageable pageable, String keyword) {
        return questionRepository.findAllQuestion( "%" + keyword + "%",pageable);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

//    @Override
//    public void insert(Question question) {
//            questionRepository.insert();
//    }

    @Override
    public void delete(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Optional<Question> findById(int id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> findQuestionByTitle( String keyword) {
        return questionRepository.findQuestionByTitle(keyword);
    }
}
