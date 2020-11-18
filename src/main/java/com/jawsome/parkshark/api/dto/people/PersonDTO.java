package com.jawsome.parkshark.api.dto.people;

import com.jawsome.parkshark.api.dto.address.AddressDTO;
import com.jawsome.parkshark.domain.instances.address.Address;
import com.jawsome.parkshark.domain.instances.people.Email;

public abstract class PersonDTO {
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private EmailDTO email;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
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
