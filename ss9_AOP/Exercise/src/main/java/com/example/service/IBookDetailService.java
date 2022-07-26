package com.example.service;

import com.example.model.DetailBook;

import java.util.List;

public interface IBookDetailService {
    List<DetailBook> findAll();

    void setStatus(Integer id);

    void returnBook(Integer bookCode) throws Exception;
}
