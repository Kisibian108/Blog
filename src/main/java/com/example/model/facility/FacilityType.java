package com.example.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "facilityType")
    @JsonManagedReference
    private Set<Facility> facility;

    public Set<Facility> getFacility() {
        return facility;
    }

    public void setFacility(Set<Facility> facility) {
        this.facility = facility;
    }

    public FacilityType(int id, String name, Set<Facility> facility) {
        this.id = id;
        this.name = name;
        this.facility = facility;
    }

    public FacilityType() {
    }

    public FacilityType(int id, String name) {
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
}
