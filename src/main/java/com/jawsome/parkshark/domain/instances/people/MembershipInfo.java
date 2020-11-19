package com.jawsome.parkshark.domain.instances.people;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "membership")
public class MembershipInfo {

    @Id
    private MembershipLevel membershipLevel;

    @Column(name = "monthly_cost")
    private int monthlyCost;

    @Column(name = "price_reduction")
    private int priceReduction;

    @Column(name = "max_parking_hours")
    private int maxParkingHours;

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public int getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(int monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public int getPriceReduction() {
        return priceReduction;
    }

    public void setPriceReduction(int priceReduction) {
        this.priceReduction = priceReduction;
    }

    public int getMaxParkingHours() {
        return maxParkingHours;
    }

    public void setMaxParkingHours(int maxParkingHours) {
        this.maxParkingHours = maxParkingHours;
    }
}
