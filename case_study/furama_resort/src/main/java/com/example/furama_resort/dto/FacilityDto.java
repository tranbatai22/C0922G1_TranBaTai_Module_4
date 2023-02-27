package com.example.furama_resort.dto;

import com.example.furama_resort.model.facility.FacilityType;
import com.example.furama_resort.model.facility.RentType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FacilityDto {
    private int id;
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[A-Z][a-z0-9\\s]*$", message = "Tên không đúng định dạng")
    private String name;
    @NotBlank(message = "Diện tích không được để trống")
    @Min(value = 1,message = "Diện tích phải là số dương")
    private int area;
    @NotBlank(message = "Giá không được để trống")
    @Min(value = 1,message = "Giá phải là số dương")
    private double cost;
    @NotBlank(message = "Số người tối đa không được để trống")
    @Min(value = 1,message = "Số người tối đa phải lớn hơn 1")
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(value = 1,message = "Diện tích bể bơi phải là một số dương")
    private double poolArea;
    @NotBlank(message = "Số tầng không được để trống")
    @Min(value = 1, message = "Số tầng phải lớn hơn 1")
    private int numberOfFloors;
    private String facilityFree;
    private FacilityType facilityType;
    private RentType rentType;

    public FacilityDto() {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
