package com.example.dto;

import com.example.model.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TradeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Pattern(regexp = "^[MGD-]+[0-9]{4}$")
    private String idTrade;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

    @NotBlank
    private String date;
    @NotBlank
    private String serviceType;

    @NotNull
    @Min(500000)
    private double price;
    @NotNull
    @Min(20)
    private double area;

    public TradeDto() {
    }

    public TradeDto(int id, String idTrade, Customer customer, String date, String serviceType, double price, double area) {
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
