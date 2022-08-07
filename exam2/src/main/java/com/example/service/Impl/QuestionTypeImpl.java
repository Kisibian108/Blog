package com.example.service.Impl;

import com.example.model.QuestionType;
import com.example.repository.IQuestionTypeRepository;
import com.example.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeImpl implements IQuestionTypeService {

    @Autowired
    IQuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
