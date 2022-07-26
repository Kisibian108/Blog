package com.example.model.facility;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentType_id", referencedColumnName = "id")
    @JsonManagedReference
    private RentType rentType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facilityType_id", referencedColumnName = "id")
    @JsonManagedReference
    private FacilityType facilityType;

    private String standardRoom;
    private String convenience;
    private double poolArea;
    private int floor;
    private String free;

    public Facility() {
    }

    public Facility(int id, String name, int area, double cost, int maxPeople, RentType rentType, String standardRoom, String convenience, double poolArea, int floor, String free) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
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

    public RentType getRentType() {
        return rentType;
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
