package com.jawsome.parkshark.domain.instances;

import javax.persistence.*;

@Entity
@Table(name = "contact_person_phone_number")

public class TelephoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "contact_person_phone_number_phone_number_id_seq")
    @Column(name = "phone_number_id")
    private int telephoneNumberId;

    @Column(name = "phone_number")
    private String telephoneNumber;

    public int getTelephoneNumberId() {
        return telephoneNumberId;
    }

    public void setTelephoneNumberId(int telephoneNumberId) {
        this.telephoneNumberId = telephoneNumberId;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }


}
