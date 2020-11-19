package com.jawsome.parkshark.domain.instances.address;

import javax.persistence.*;

@Entity
@Table
public class Country {
    @Id
    @Column(name = "country_code_id")
    private String countryCode;
    @Column(name = "country")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
