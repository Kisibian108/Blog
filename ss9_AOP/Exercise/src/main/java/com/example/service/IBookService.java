package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    void save(Book book);

    void borrowBook(Integer id);

    void setQuantity(Integer id);

}
