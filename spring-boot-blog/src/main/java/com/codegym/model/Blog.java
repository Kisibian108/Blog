package com.codegym.model;

import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {

    @Id
    private int id;
    private String name;

    public Blog() {
    }

    public Blog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
