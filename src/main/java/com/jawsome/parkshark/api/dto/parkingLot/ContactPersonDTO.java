package com.jawsome.parkshark.api.dto.parkingLot;

import com.jawsome.parkshark.api.dto.people.EmailDTO;
import com.jawsome.parkshark.api.dto.people.PersonDTO;
import com.jawsome.parkshark.domain.instances.MobilePhoneNumber;
import com.jawsome.parkshark.domain.instances.TelephoneNumber;
import com.jawsome.parkshark.domain.instances.address.ContactPersonAddress;
import com.jawsome.parkshark.domain.instances.people.Email;

public class ContactPersonDTO extends PersonDTO {
    private MobilePhoneNumberDTO mobilePhoneNumberDTO;
    private TelephoneNumberDTO telephoneNumberDTO;
    private EmailDTO emailDTO;
    private ContactPersonAddressDTO contactPersonAddressDTO;

    public MobilePhoneNumberDTO getMobilePhoneNumberDTO() {
        return mobilePhoneNumberDTO;
    }

    public void setMobilePhoneNumberDTO(MobilePhoneNumberDTO mobilePhoneNumberDTO) {
        this.mobilePhoneNumberDTO = mobilePhoneNumberDTO;
    }

    public TelephoneNumberDTO getTelephoneNumberDTO() {
        return telephoneNumberDTO;
    }

    public void setTelephoneNumberDTO(TelephoneNumberDTO telephoneNumberDTO) {
        this.telephoneNumberDTO = telephoneNumberDTO;
    }

    public EmailDTO getEmailDTO() {
        return emailDTO;
    }

    public void setEmailDTO(EmailDTO emailDTO) {
        this.emailDTO = emailDTO;
    }

    public ContactPersonAddressDTO getContactPersonAddressDTO() {
        return contactPersonAddressDTO;
    }

    public void setContactPersonAddressDTO(ContactPersonAddressDTO contactPersonAddressDTO) {
        this.contactPersonAddressDTO = contactPersonAddressDTO;
    }
}
