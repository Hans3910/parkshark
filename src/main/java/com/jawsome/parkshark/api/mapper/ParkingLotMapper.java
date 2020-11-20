package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.address.CityDTO;
import com.jawsome.parkshark.api.dto.address.CountryDTO;
import com.jawsome.parkshark.api.dto.parkingLot.*;
import com.jawsome.parkshark.api.dto.people.EmailDTO;
import com.jawsome.parkshark.domain.instances.*;
import com.jawsome.parkshark.domain.instances.address.City;
import com.jawsome.parkshark.domain.instances.address.ContactPersonAddress;
import com.jawsome.parkshark.domain.instances.address.Country;
import com.jawsome.parkshark.domain.instances.people.Email;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {
    public ParkingLot convertParkingLotDtoToParkingLot(CreateParkingLotDTO createParkingLotDTO) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(createParkingLotDTO.getName());
        parkingLot.setCategory(createParkingLotDTO.getCategory());
        parkingLot.setMaxCapacity(createParkingLotDTO.getMaxCapacity());
        convertContactPersonDtoToContactPerson(createParkingLotDTO.getContactPersonDTO());
        convertParkingLotAddressDtoToParkingLotAddress(createParkingLotDTO.getParkingAddressDTO());
        parkingLot.setPricePerHour(createParkingLotDTO.getPricePerHour());
        return parkingLot;
    }

    public ContactPerson convertContactPersonDtoToContactPerson(ContactPersonDTO contactPersonDTO) {
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setFirstName(contactPersonDTO.getFirstName());
        contactPerson.setLastName(contactPersonDTO.getLastName());
        convertMobilePhoneNumberDtoToMobilePhoneNumber(contactPersonDTO.getMobilePhoneNumberDTO());
        convertTelephoneNumberDtoToTelephoneNumber(contactPersonDTO.getTelephoneNumberDTO());
        convertEmailDtoToEmail(contactPersonDTO.getEmailDTO());
        convertContactPersonAddressDtoToContactPersonAddress(contactPersonDTO.getContactPersonAddressDTO());
        return contactPerson;
    }

    public MobilePhoneNumber convertMobilePhoneNumberDtoToMobilePhoneNumber(MobilePhoneNumberDTO mobilePhoneNumberDTO) {
        MobilePhoneNumber mobilePhoneNumber = new MobilePhoneNumber();
        mobilePhoneNumber.setMobilePhoneNumber(mobilePhoneNumberDTO.getMobilePhoneNumber());
        return mobilePhoneNumber;
    }

    public TelephoneNumber convertTelephoneNumberDtoToTelephoneNumber(TelephoneNumberDTO telephoneNumberDTO) {
        TelephoneNumber telephoneNumber = new TelephoneNumber();
        telephoneNumber.setTelephoneNumber(telephoneNumberDTO.getTelephoneNumber());
        return telephoneNumber;
    }

    public Email convertEmailDtoToEmail(EmailDTO emailDTO) {
        Email email = new Email();
        email.setEmail(emailDTO.getEmail());
        return email;
    }

    public ContactPersonAddress convertContactPersonAddressDtoToContactPersonAddress(ContactPersonAddressDTO contactPersonAddressDTO) {
        ContactPersonAddress contactPersonAddress = new ContactPersonAddress();
        contactPersonAddress.setStreetName(contactPersonAddressDTO.getStreetName());
        contactPersonAddress.setStreetNumber(contactPersonAddressDTO.getStreetNumber());
        convertCityDtoToCity(contactPersonAddressDTO.getCity());
        return contactPersonAddress;
    }

    public City convertCityDtoToCity(CityDTO cityDTO) {
        City city = new City();
        city.setCityName(cityDTO.getCityName());
        city.setPostalCode(cityDTO.getPostalCode());
        convertCountryDtoToCountry(cityDTO.getCountry());
        return city;

    }

    public Country convertCountryDtoToCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setCountryCode(countryDTO.getCountryCode());
        country.setCountry(countryDTO.getCountry());
        return country;
    }

    public ParkingLotAddress convertParkingLotAddressDtoToParkingLotAddress(ParkingLotAddressDTO parkingLotAddressDTO) {
        ParkingLotAddress parkingLotAddress = new ParkingLotAddress();
        parkingLotAddress.setStreetName(parkingLotAddressDTO.getStreetName());
        parkingLotAddress.setStreetNumber(parkingLotAddressDTO.getStreetNumber());
        convertCityDtoToCity(parkingLotAddressDTO.getCity());
        return parkingLotAddress;
    }
}
