package com.jawsome.parkshark.domain.instances;

import javax.persistence.*;

@Entity
@Table(name = "contact_person_mobile_phone_number")
public class MobilePhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "contact_person_mobile_phone_number_mobile_number_id_seq")
    @Column(name = "mobile_number_id")
    private int mobilePhoneNumberId;

    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;

    public int getMobilePhoneNumberId() {
        return mobilePhoneNumberId;
    }

    public void setMobilePhoneNumberId(int mobilePhoneNumberId) {
        this.mobilePhoneNumberId = mobilePhoneNumberId;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
}
