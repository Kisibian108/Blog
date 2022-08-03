package com.example.dto.facility;

import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class FacilityDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentType_id", referencedColumnName = "id")
    @JsonBackReference
    private RentType rentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facilityType_id", referencedColumnName = "id")
    @JsonBackReference
    private FacilityType facilityType;

    private String standardRoom;
    private String convenience;
    private double poolArea;
    private int floor;
    private String free;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, int area, double cost, int maxPeople, RentType rentType, FacilityType facilityType, String standardRoom, String convenience, double poolArea, int floor, String free) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.convenience = convenience;
        this.poolArea = poolArea;
        this.floor = floor;
        this.free = free;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public double getCost() {
        return cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public String getConvenience() {
        return convenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public String getFree() {
        return free;
    }
}
