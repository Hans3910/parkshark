package com.jawsome.parkshark.domain.instances.people;

import com.jawsome.parkshark.domain.instances.address.MemberAddress;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
public class Member extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "member_member_id_seq")
    @Column(name = "member_id")
    private int memberId;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "vehicle_id")
    private LicensePlate licensePlate;

    @Column(name = "registration_date")
    private LocalDateTime localDateTime = LocalDateTime.now();


    @OneToOne(cascade = {})
    @JoinColumn(name = "membership_level_id")
    private MembershipInfo membershipInfo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "member_address_id")
    private MemberAddress memberAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    @Column(name = "email")
    private Email email;


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

    public MembershipInfo getMembershipInfo() {
        return membershipInfo;
    }

    public void setMembershipInfo(MembershipInfo membershipInfo) {
        this.membershipInfo = membershipInfo;
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
