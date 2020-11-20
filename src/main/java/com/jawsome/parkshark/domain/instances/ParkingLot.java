package com.jawsome.parkshark.domain.instances;

import com.jawsome.parkshark.domain.instances.divisions.Division;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "parking_lot_parking_lot_id_seq")
    @Column(name = "parking_lot_id")
    private int parkingLotId;

    @Column(name = "division_id")
    private int divisionId;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "max_capacity")
    private int maxCapacity;

    @Column(name = "contact_person_id")
    private int contactPersonId;


    @Column(name = "parking_address_id")
    private int parkingAddressId;

    @Column(name = "price_per_hour")
    private int pricePerHour;

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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