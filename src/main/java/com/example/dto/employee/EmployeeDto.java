package com.example.dto.employee;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Position;
import com.example.model.employee.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class EmployeeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String birthday;
    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$")
    private String idCard;
    @Min(1)
    private double salary;
    @Pattern(regexp = "^[090|091|(84)+90|(84)+91]+[0-9]{7}$")
    private String phoneNumber;
    @Email(message = "Email is not valid", regexp = "^\\w+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?")
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    @JsonManagedReference
    private Division division;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    @JsonManagedReference
    private Position position;

    @ManyToOne
    @JoinColumn(name = "educationDegree_id", referencedColumnName = "id")
    @JsonManagedReference
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    @JsonManagedReference
    private User user;

    public EmployeeDto() {
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
