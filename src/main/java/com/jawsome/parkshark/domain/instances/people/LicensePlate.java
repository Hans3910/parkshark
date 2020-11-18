package com.jawsome.parkshark.domain.instances.people;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LicensePlate {

    @Id
    private int vehicleId;
    private String plateNumber;
    private String issuingCountry;

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

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }
}
