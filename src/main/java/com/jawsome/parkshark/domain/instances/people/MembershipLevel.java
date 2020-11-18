package com.jawsome.parkshark.domain.instances.people;

public enum MembershipLevel {

    BRONZE(0,0,4),
    SILVER(10,20,6),
    GOLD(40,30,24);

    private final int monthlyCost;
    private final int priceReduction;
    private final int maxParkingHours;

    MembershipLevel(int monthlyCost, int priceReduction, int maxParkingHours) {
        this.monthlyCost = monthlyCost;
        this.priceReduction = priceReduction;
        this.maxParkingHours = maxParkingHours;
    }
}
