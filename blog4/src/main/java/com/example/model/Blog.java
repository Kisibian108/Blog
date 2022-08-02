package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String author;

    public Blog() {
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference
    private Category category;

//    @OneToMany(mappedBy = "blog")
//    private Set<Category> category;

    public Blog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Blog(int id, String name, String description, String author) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public Blog(int id, String name, String description, String author, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
