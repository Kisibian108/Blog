package com.example.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "rentType")
    @JsonManagedReference
    private Set<Facility> facility;

    public void setFacility(Set<Facility> facility) {
        this.facility = facility;
    }

    public RentType() {
    }

    public RentType(int id, String name, Set<Facility> facility) {
        this.id = id;
        this.name = name;
        this.facility = facility;
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


}
