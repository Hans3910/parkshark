package com.jawsome.parkshark.api.dto.people;

import com.jawsome.parkshark.api.dto.address.AddressDTO;
import com.jawsome.parkshark.api.dto.address.MemberAddressDTO;
import com.jawsome.parkshark.domain.instances.people.LicensePlate;
import com.jawsome.parkshark.domain.instances.people.MembershipInfo;
import com.jawsome.parkshark.domain.instances.people.MembershipLevel;

import java.time.LocalDateTime;

public class CreateMemberDTO extends PersonDTO {
    private LicensePlateDTO licensePlate;
    private MembershipInfoDTO membershipInfoDTO;
    private MemberAddressDTO memberAddressDTO;
    private EmailDTO email;
    private String phoneNumber;

    public LicensePlateDTO getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlateDTO licensePlate) {
        this.licensePlate = licensePlate;
    }

    public MembershipInfoDTO getMembershipInfoDTO() {
        return membershipInfoDTO;
    }

    public void setMembershipInfoDTO(MembershipInfoDTO membershipInfoDTO) {
        this.membershipInfoDTO = membershipInfoDTO;
    }

    public MemberAddressDTO getMemberAddressDTO() {
        return memberAddressDTO;
    }

    public void setMemberAddressDTO(MemberAddressDTO memberAddressDTO) {
        this.memberAddressDTO = memberAddressDTO;
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
