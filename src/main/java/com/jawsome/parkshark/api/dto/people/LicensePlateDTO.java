package com.jawsome.parkshark.api.dto.people;

import com.jawsome.parkshark.domain.instances.address.Country;

public class LicensePlateDTO {
    private String plateNumber;
    private Country countryCodeId;

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
