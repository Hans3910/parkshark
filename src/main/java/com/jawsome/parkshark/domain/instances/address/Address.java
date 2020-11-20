package com.jawsome.parkshark.domain.instances.address;

import javax.persistence.*;

@MappedSuperclass
public abstract class Address {
    @Column
    private String streetName;
    @Column
    private String streetNumber;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="postal_code_id")
    private City city;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
