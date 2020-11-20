package com.jawsome.parkshark.api.dto.parkingLot;

import com.jawsome.parkshark.domain.instances.Category;

public class CreateParkingLotDTO {

    private String name;
    private int divisionId;
    private Category category;
    private int maxCapacity;
    private int contactPersonId;
    private int parkingAddressId;
    private int pricePerHour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(int contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public int getParkingAddressId() {
        return parkingAddressId;
    }

    public void setParkingAddressId(int parkingAddressId) {
        this.parkingAddressId = parkingAddressId;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}