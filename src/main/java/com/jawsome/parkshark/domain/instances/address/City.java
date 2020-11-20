package com.jawsome.parkshark.domain.instances.address;


import javax.persistence.*;

@Entity
@Table
public class City {
    @Id
    @Column(name="postal_code_id")
    private int postalCode;
    @Column(name="city")
    private String cityName;

    @ManyToOne/*(cascade = {CascadeType.ALL})*/ // <= CASCADE HAS TO GO
    // Countries are a fixed list
    // You do not want to add/delete a country, when you remove/add a license plate
    // (This might cause some political problems)
    // Please save list of countries first to DB before using them
    @JoinColumn(name = "country_code_id")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
