package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String idTrade;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

    private String date;
    private String serviceType;
    private double price;
    private double area;

    public Trade() {
    }

    public Trade(int id, String idTrade, Customer customer, String date, String serviceType, double price, double area) {
        this.id = id;
        this.idTrade = idTrade;
        this.customer = customer;
        this.date = date;
        this.serviceType = serviceType;
        this.price = price;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdTrade() {
        return idTrade;
    }

    public void setIdTrade(String idTrade) {
        this.idTrade = idTrade;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
