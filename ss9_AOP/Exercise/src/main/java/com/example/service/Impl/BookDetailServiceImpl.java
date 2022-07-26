package com.example.service.Impl;

import com.example.model.DetailBook;
import com.example.repository.IBookDetailRepository;
import com.example.repository.IBookRepository;
import com.example.service.IBookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailServiceImpl implements IBookDetailService {
    @Autowired
    private IBookDetailRepository detailBookRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<DetailBook> findAll() {
        return this.detailBookRepository.findAll();
    }

    @Override
    public void setStatus(Integer id) {
        this.detailBookRepository.setStatus(id);
    }

    @Override
    public void returnBook(Integer bookCode) throws Exception {
        List<DetailBook> detailBooks = this.detailBookRepository.findAll();
        DetailBook detailBook = this.detailBookRepository.getByBookCode(bookCode);
        if (checkBookCodeExists(bookCode,detailBooks)) {
            this.detailBookRepository.updateStatus(detailBook.getId());
            this.bookRepository.updateQuantity(detailBook.getBook().getId());
        } else {
            throw new Exception();
        }
    }

    private boolean checkBookCodeExists(Integer bookCode, List<DetailBook> detailBooks) {
        for (DetailBook detailBook: detailBooks) {
            if (detailBook.getBookCode().equals(bookCode) && detailBook.getStatus()) {
                return true;
            }
        }
        return false;
    }
}
