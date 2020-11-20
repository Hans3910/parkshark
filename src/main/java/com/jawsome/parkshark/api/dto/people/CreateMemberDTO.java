package com.jawsome.parkshark.api.dto.people;

import com.jawsome.parkshark.api.dto.address.MemberAddressDTO;

public class CreateMemberDTO extends PersonDTO {
    private LicensePlateDTO licensePlate;
    private MembershipInfoDTO membershipInfo;
    private MemberAddressDTO memberAddress;
    private EmailDTO email;
    private String phoneNumber;

    public LicensePlateDTO getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlateDTO licensePlate) {
        this.licensePlate = licensePlate;
    }

    public MembershipInfoDTO getMembershipInfo() {
        return membershipInfo;
    }

    public void setMembershipInfo(MembershipInfoDTO membershipInfo) {
        this.membershipInfo = membershipInfo;
    }

    public MemberAddressDTO getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(MemberAddressDTO memberAddress) {
        this.memberAddress = memberAddress;
    }

    public EmailDTO getEmail() {
        return email;
    }

    public void setEmail(EmailDTO email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
