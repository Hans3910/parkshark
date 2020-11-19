package com.jawsome.parkshark.api.dto.people;

import com.jawsome.parkshark.api.dto.address.AddressDTO;
import com.jawsome.parkshark.domain.instances.address.Address;
import com.jawsome.parkshark.domain.instances.people.Email;

public abstract class PersonDTO {
    private String firstName;
    private String lastName;

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

}
