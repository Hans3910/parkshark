package com.jawsome.parkshark.domain.instances.people;

import com.jawsome.parkshark.domain.instances.address.Country;

import javax.persistence.*;

@Entity
@Table(name = "license_plate")
public class LicensePlate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "license_plate_vehicle_id_seq")
    @Column(name = "vehicle_id")
    private int vehicleId;
    @Column(name = "license_plate")
    private String plateNumber;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "country_code_id")
    private Country countryCodeId;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Country getCountryCodeId() {
        return countryCodeId;
    }

    public void setCountryCodeId(Country countryCodeId) {
        this.countryCodeId = countryCodeId;
    }
}
