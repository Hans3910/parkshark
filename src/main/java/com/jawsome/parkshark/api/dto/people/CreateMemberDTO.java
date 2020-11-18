package com.jawsome.parkshark.api.dto.people;

import com.jawsome.parkshark.domain.instances.people.LicensePlate;
import com.jawsome.parkshark.domain.instances.people.MembershipLevel;

import java.time.LocalDateTime;

public class MemberDTO extends PersonDTO {
    private LicensePlateDTO licensePlate;
    private LocalDateTime localDateTime;
    private MembershipLevel membershipLevel;
    private int memberId;

    public LicensePlateDTO getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlateDTO licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
