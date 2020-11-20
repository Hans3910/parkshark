package com.jawsome.parkshark.domain.instances;

import com.jawsome.parkshark.domain.instances.address.Address;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot_address")
public class ParkingLotAddress extends Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "parking_lot_address_parking_address_id_seq")
    @Column(name = "parking_address_id")
    private int parkingLotAddressId;

    public int getParkingLotAddressId() { return parkingLotAddressId; }

}
