package com.jawsome.parkshark.domain.instances.people;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LicensePlate {

    @Id
    private int vehicleId;
    private String plateNumber;
    private String issuingCountry;
}
