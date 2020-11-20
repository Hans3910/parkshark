package com.jawsome.parkshark.domain.instances;

import com.jawsome.parkshark.domain.instances.address.Address;
import com.jawsome.parkshark.domain.instances.address.ContactPersonAddress;
import com.jawsome.parkshark.domain.instances.people.Email;
import com.jawsome.parkshark.domain.instances.people.Person;

import javax.persistence.*;

@Entity
@Table(name = "contact_person")
public class ContactPerson extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "contact_person_contact_person_id_seq")
    @Column(name = "contact_person_id")
    private int contactPersonId;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "mobile_number_id")
    private MobilePhoneNumber mobilePhoneNumberId;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "phone_number_id")
    private TelephoneNumber telephoneNumberId;

    @Embedded()
    @Column(name = "contact_email")
    private Email email;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contact_address_id")
    private ContactPersonAddress contactPersonAddressId;

    public int getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(int contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public MobilePhoneNumber getMobilePhoneNumberId() {
        return mobilePhoneNumberId;
    }

    public void setMobilePhoneNumberId(MobilePhoneNumber mobilePhoneNumberId) {
        this.mobilePhoneNumberId = mobilePhoneNumberId;
    }

    public TelephoneNumber getTelephoneNumberId() {
        return telephoneNumberId;
    }

    public void setTelephoneNumberId(TelephoneNumber telephoneNumberId) {
        this.telephoneNumberId = telephoneNumberId;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public ContactPersonAddress getContactPersonAddressId() {
        return contactPersonAddressId;
    }

    public void setContactPersonAddressId(ContactPersonAddress contactPersonAddressId) {
        this.contactPersonAddressId = contactPersonAddressId;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "contactPersonId=" + contactPersonId +
                ", mobilePhoneNumberId=" + mobilePhoneNumberId +
                ", telephoneNumberId=" + telephoneNumberId +
                ", email=" + email +
                ", contactPersonAddressId=" + contactPersonAddressId +
                '}';
    }
}
