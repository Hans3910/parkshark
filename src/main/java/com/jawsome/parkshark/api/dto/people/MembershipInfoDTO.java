package com.jawsome.parkshark.api.dto.people;

import com.jawsome.parkshark.domain.instances.people.MembershipLevel;

public class MembershipInfoDTO {

    private MembershipLevel membershipLevel;
//    private int monthlyCost;
//    private int priceReduction;
//    private int maxParkingHours;

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

//    public int getMonthlyCost() {
//        return monthlyCost;
//    }
//
//    public void setMonthlyCost(int monthlyCost) {
//        this.monthlyCost = monthlyCost;
//    }
//
//    public int getPriceReduction() {
//        return priceReduction;
//    }
//
//    public void setPriceReduction(int priceReduction) {
//        this.priceReduction = priceReduction;
//    }
//
//    public int getMaxParkingHours() {
//        return maxParkingHours;
//    }
//
//    public void setMaxParkingHours(int maxParkingHours) {
//        this.maxParkingHours = maxParkingHours;
//    }
}
