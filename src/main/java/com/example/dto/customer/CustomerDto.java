package com.example.dto.customer;

import com.example.model.customer.CustomerType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
public class CustomerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "customertype_id", referencedColumnName = "id")
    @JsonBackReference
    private CustomerType customerType;

    private String name;
    private String birthday;
    private String gender;
    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$")
    private String idCard;
    @Pattern(regexp = "^[090|091|(84)+90|(84)+91]+[0-9]{7}$")
    private String phoneNumber;
    @Email(message = "Email is not valid", regexp = "^\\w+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?")
    private String email;
    private String address;

    public CustomerDto() {
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerDto(int id, String name, String birthday, String gender, String idCard, String phoneNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
