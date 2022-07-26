package com.example.service.Impl;

import com.example.model.Book;
import com.example.model.DetailBook;
import com.example.repository.IBookDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    IBookRepository bookRepository;

    @Autowired
    IBookDetailRepository bookDetailRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void borrowBook(Integer id) {
        Book book = this.bookRepository.getById(id);
        if (this.bookDetailRepository.existsById(id)) {
            for (int i = 0; i < book.getQuantity(); i++) {
                List<DetailBook> detailBooks = this.bookDetailRepository.findAll();
                DetailBook detailBook = new DetailBook();
                detailBook.setBookCode(getRandomNumber(detailBooks));
                detailBook.setStatus(false);
                detailBook.setBook(book);
                this.bookDetailRepository.save(detailBook);
            }
        }
    }

    @Override
    public void setQuantity(Integer id) {
        this.bookRepository.setQuantity(this.bookDetailRepository.getById(id).getBook().getId());
    }

    private int getRandomNumber(List<DetailBook> detailBooks) {
        int randomNumber = 10000;
        while (checkExists(detailBooks, randomNumber)) {
            randomNumber = (int) ((Math.random() * 89999) + 10001);
        }
        return randomNumber;
    }

    private boolean checkExists(List<DetailBook> detailBooks, int randomNumber) {
        for (DetailBook detailBook : detailBooks) {
            if (detailBook.getBookCode() == randomNumber) {
                return true;
            }
        }
        return false;
    }
}
