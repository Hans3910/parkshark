package com.jawsome.parkshark.domain.instances;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "parking_lot_parking_lot_id_seq")
    @Column(name = "parking_lot_id")
    private int parkingLotId;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "max_capacity")
    private int maxCapacity;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contact_person_id")
    private ContactPerson contactPerson;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parking_address_id")
    private ParkingLotAddress parkingAddress;

    @Column(name = "price_per_hour")
    private int pricePerHour;

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
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

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public ParkingLotAddress getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(ParkingLotAddress parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingLotId=" + parkingLotId +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", maxCapacity=" + maxCapacity +
                ", contactPerson=" + contactPerson +
                ", parkingAddress=" + parkingAddress +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
