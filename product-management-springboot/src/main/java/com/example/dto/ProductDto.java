package com.example.dto;


import javax.validation.constraints.*;

public class ProductDto {

    private int id;

    @NotBlank
    @Size(min = 5,max = 40)
    private String name;

    @NotNull
    private double price;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String description;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String manufacturing;

    public ProductDto() {
    }

    public ProductDto(int id, String name, double price, String description, String manufacturing) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturing = manufacturing;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(String manufacturing) {
        this.manufacturing = manufacturing;
    }
}
