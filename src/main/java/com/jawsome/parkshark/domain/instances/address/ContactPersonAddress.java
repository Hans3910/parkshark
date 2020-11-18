package com.jawsome.parkshark.domain.instances.address;

import javax.persistence.*;

@Entity
@Table(name = "contact_person_address")
public class ContactPersonAddress extends Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "contact_person_address_contact_address_id_seq")
    @Column(name = "contact_address_id")
    private int contactAddressId;

    public int getContactAddressId() {
        return contactAddressId;
    }
}
