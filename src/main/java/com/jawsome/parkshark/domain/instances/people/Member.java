package com.jawsome.parkshark.domain.instances.people;

import com.jawsome.parkshark.domain.instances.address.MemberAddress;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
public class Member extends Person {

    @OneToOne
    private LicensePlate licensePlate;
    private LocalDateTime localDateTime;
    private MembershipLevel membershipLevel;
    @OneToOne
    private MemberAddress memberAddress;
    private String phoneNumber;
    @Embedded
    private Email email;

    @Id
    private int memberId;

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
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

    public MemberAddress getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(MemberAddress memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
