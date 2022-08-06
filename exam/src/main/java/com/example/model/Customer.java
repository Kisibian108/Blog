package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private Set<Trade> tradeSet;

    private String name;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(int id, Set<Trade> tradeSet, String name, String phone, String email) {
        this.id = id;
        this.tradeSet = tradeSet;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Trade> getTradeSet() {
        return tradeSet;
    }

    public void setTradeSet(Set<Trade> tradeSet) {
        this.tradeSet = tradeSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
