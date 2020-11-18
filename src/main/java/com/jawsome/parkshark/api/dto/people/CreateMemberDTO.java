package com.jawsome.parkshark.api.dto.people;

import com.jawsome.parkshark.domain.instances.people.LicensePlate;
import com.jawsome.parkshark.domain.instances.people.MembershipLevel;

import java.time.LocalDateTime;

public class CreateMemberDTO extends PersonDTO {
    private LicensePlateDTO licensePlate;
    private String membershipLevel;

    public LicensePlateDTO getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlateDTO licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

}
