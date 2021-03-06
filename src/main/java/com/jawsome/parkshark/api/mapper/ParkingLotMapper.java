package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.address.CityDTO;
import com.jawsome.parkshark.api.dto.address.CountryDTO;
import com.jawsome.parkshark.api.dto.division.GetDivisionDTO;
import com.jawsome.parkshark.api.dto.parkingLot.*;
import com.jawsome.parkshark.api.dto.people.EmailDTO;
import com.jawsome.parkshark.domain.instances.*;
import com.jawsome.parkshark.domain.instances.address.City;
import com.jawsome.parkshark.domain.instances.address.ContactPersonAddress;
import com.jawsome.parkshark.domain.instances.address.Country;
import com.jawsome.parkshark.domain.instances.divisions.Division;
import com.jawsome.parkshark.domain.instances.people.Email;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingLotMapper {


    public ParkingLot convertParkingLotDtoToParkingLot(CreateParkingLotDTO createParkingLotDTO) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setDivisionId(createParkingLotDTO.getDivisionId());
        parkingLot.setName(createParkingLotDTO.getName());
        parkingLot.setCategory(createParkingLotDTO.getCategory());
        parkingLot.setMaxCapacity(createParkingLotDTO.getMaxCapacity());
        parkingLot.setContactPersonId(createParkingLotDTO.getContactPersonId());
        parkingLot.setParkingAddressId(createParkingLotDTO.getParkingAddressId());
        parkingLot.setPricePerHour(createParkingLotDTO.getPricePerHour());
        return parkingLot;
    }

    public GetParkingLotDTO convertParkingLotToGetParkingLotDto(ParkingLot parkingLot) {
        GetParkingLotDTO getParkingLotDTO = new GetParkingLotDTO();
        getParkingLotDTO.setDivisionId(parkingLot.getDivisionId());
        getParkingLotDTO.setName(parkingLot.getName());
        getParkingLotDTO.setCategory(getParkingLotDTO.getCategory());
        getParkingLotDTO.setMaxCapacity(getParkingLotDTO.getMaxCapacity());
        getParkingLotDTO.setContactPersonId(parkingLot.getContactPersonId());
        getParkingLotDTO.setParkingAddressId(parkingLot.getParkingLotId());
        getParkingLotDTO.setPricePerHour(parkingLot.getPricePerHour());
        return getParkingLotDTO;
    }

    public List<GetParkingLotDTO> convertParkingLotListToParkingLotDtoList(List<ParkingLot> parkingLotList) {
        List<GetParkingLotDTO> divisionDTOList = new ArrayList();
        return parkingLotList.stream().map(parkingLot -> convertParkingLotToGetParkingLotDto(parkingLot)).collect(Collectors.toList());
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
