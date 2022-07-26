package com.example.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
public class DetailBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer bookCode;

    @Value("false")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public DetailBook() {
    }

    public DetailBook(Integer id, Integer bookCode, Boolean status, Book book) {
        this.id = id;
        this.bookCode = bookCode;
        this.status = status;
        this.book = book;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookCode() {
        return bookCode;
    }

    public void setBookCode(Integer bookCode) {
        this.bookCode = bookCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
