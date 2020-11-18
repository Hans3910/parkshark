package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.address.AddressDTO;
import com.jawsome.parkshark.api.dto.address.CityDTO;
import com.jawsome.parkshark.api.dto.address.CountryDTO;
import com.jawsome.parkshark.api.dto.people.CreateMemberDTO;
import com.jawsome.parkshark.api.dto.people.LicensePlateDTO;
import com.jawsome.parkshark.domain.instances.address.Address;
import com.jawsome.parkshark.domain.instances.address.City;
import com.jawsome.parkshark.domain.instances.address.Country;
import com.jawsome.parkshark.domain.instances.people.Email;
import com.jawsome.parkshark.domain.instances.people.LicensePlate;
import com.jawsome.parkshark.domain.instances.people.Member;
import com.jawsome.parkshark.domain.instances.people.MembershipLevel;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member toEntity(CreateMemberDTO createMemberDTO){
        Member member = new Member();

        LicensePlate licensePlate = new LicensePlate();
        licensePlate.setPlateNumber(createMemberDTO.getLicensePlate().getPlateNumber());
        licensePlate.setIssuingCountry(createMemberDTO.getLicensePlate().getIssuingCountry());

        Country country = new Country();
        country.setCountryCode(createMemberDTO.getAddress().getCity().getCountry().getCountryCode());

        City city = new City();
        city.setCityName(createMemberDTO.getAddress().getCity().getCityName());
        city.setPostalCode(createMemberDTO.getAddress().getCity().getPostalCode());
        city.setCountry(country);

        Address address = new Address();
        address.setStreetName(createMemberDTO.getAddress().getStreetName());
        address.setStreetNumber(createMemberDTO.getAddress().getStreetNumber());
        address.setCity(city);

        member.setFirstName(createMemberDTO.getFirstName());
        member.setLastName(createMemberDTO.getLastName());
        member.setPhoneNumber(createMemberDTO.getPhoneNumber());
        member.setLicensePlate(licensePlate);
        member.setEmail(new Email(createMemberDTO.getEmail().getEmail()));
        member.setAddress(address);
        member.setMembershipLevel(MembershipLevel.valueOf(createMemberDTO.getMembershipLevel().toUpperCase()));

        return member;
    };

    public CreateMemberDTO toCreateDTO(Member member){
        CreateMemberDTO createMemberDTO = new CreateMemberDTO();

        LicensePlateDTO licensePlateDTO = new LicensePlateDTO();
        licensePlateDTO.setPlateNumber(member.getLicensePlate().getPlateNumber());
        licensePlateDTO.setIssuingCountry(member.getLicensePlate().getIssuingCountry());

        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryCode(member.getAddress().getCity().getCountry().getCountryCode());

        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityName(member.getAddress().getCity().getCityName());
        cityDTO.setPostalCode(member.getAddress().getCity().getPostalCode());
        cityDTO.setCountry(countryDTO);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreetName(member.getAddress().getStreetName());
        addressDTO.setStreetNumber(member.getAddress().getStreetNumber());
        addressDTO.setCity(cityDTO);

        createMemberDTO.setFirstName(member.getFirstName());
        createMemberDTO.setLastName(member.getLastName());
        createMemberDTO.setPhoneNumber(member.getPhoneNumber());
        createMemberDTO.setLicensePlate(licensePlateDTO);
        createMemberDTO.setAddress(addressDTO);
        createMemberDTO.setMembershipLevel(member.getMembershipLevel().toString());

        return createMemberDTO;
    }
}
