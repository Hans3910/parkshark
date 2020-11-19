package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.address.CityDTO;
import com.jawsome.parkshark.api.dto.address.CountryDTO;
import com.jawsome.parkshark.api.dto.address.MemberAddressDTO;
import com.jawsome.parkshark.api.dto.people.CreateMemberDTO;
import com.jawsome.parkshark.api.dto.people.LicensePlateDTO;
import com.jawsome.parkshark.api.dto.people.MembershipInfoDTO;
import com.jawsome.parkshark.domain.instances.address.City;
import com.jawsome.parkshark.domain.instances.address.Country;
import com.jawsome.parkshark.domain.instances.address.MemberAddress;
import com.jawsome.parkshark.domain.instances.people.*;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member toEntity(CreateMemberDTO createMemberDTO){
        Member member = new Member();

        LicensePlate licensePlate = new LicensePlate();
        licensePlate.setPlateNumber(createMemberDTO.getLicensePlate().getPlateNumber());
        licensePlate.setIssuingCountry(createMemberDTO.getLicensePlate().getIssuingCountry());

        Country country = new Country();
        country.setCountryCode(createMemberDTO.getMemberAddressDTO().getCity().getCountry().getCountryCode());

        City city = new City();
        city.setCityName(createMemberDTO.getMemberAddressDTO().getCity().getCityName());
        city.setPostalCode(createMemberDTO.getMemberAddressDTO().getCity().getPostalCode());
        city.setCountry(country);

        MemberAddress address = new MemberAddress();
        address.setStreetName(createMemberDTO.getMemberAddressDTO().getStreetName());
        address.setStreetNumber(createMemberDTO.getMemberAddressDTO().getStreetNumber());
        address.setCity(city);

        MembershipInfo membershipInfo = new MembershipInfo();
        membershipInfo.setMembershipLevel(createMemberDTO.getMembershipInfoDTO().getMembershipLevel());
        membershipInfo.setMonthlyCost(createMemberDTO.getMembershipInfoDTO().getMonthlyCost());
        membershipInfo.setPriceReduction(createMemberDTO.getMembershipInfoDTO().getPriceReduction());
        membershipInfo.setMaxParkingHours(createMemberDTO.getMembershipInfoDTO().getMaxParkingHours());

        member.setFirstName(createMemberDTO.getFirstName());
        member.setLastName(createMemberDTO.getLastName());
        member.setPhoneNumber(createMemberDTO.getPhoneNumber());
        member.setLicensePlate(licensePlate);
        member.setEmail(new Email(createMemberDTO.getEmail().getEmail()));
        member.setMemberAddress(address);
        member.setMembershipInfo(membershipInfo);

        return member;
    };

    public CreateMemberDTO toCreateDTO(Member member){
        CreateMemberDTO createMemberDTO = new CreateMemberDTO();

        LicensePlateDTO licensePlateDTO = new LicensePlateDTO();
        licensePlateDTO.setPlateNumber(member.getLicensePlate().getPlateNumber());
        licensePlateDTO.setIssuingCountry(member.getLicensePlate().getIssuingCountry());

        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryCode(member.getMemberAddress().getCity().getCountry().getCountryCode());

        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityName(member.getMemberAddress().getCity().getCityName());
        cityDTO.setPostalCode(member.getMemberAddress().getCity().getPostalCode());
        cityDTO.setCountry(countryDTO);

        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setStreetName(member.getMemberAddress().getStreetName());
        memberAddressDTO.setStreetNumber(member.getMemberAddress().getStreetNumber());
        memberAddressDTO.setCity(cityDTO);

        MembershipInfoDTO membershipInfoDTO = new MembershipInfoDTO();
        membershipInfoDTO.setMembershipLevel(member.getMembershipInfo().getMembershipLevel());
        membershipInfoDTO.setMonthlyCost(member.getMembershipInfo().getMonthlyCost());
        membershipInfoDTO.setPriceReduction(member.getMembershipInfo().getPriceReduction());
        membershipInfoDTO.setMaxParkingHours(member.getMembershipInfo().getMaxParkingHours());

        createMemberDTO.setFirstName(member.getFirstName());
        createMemberDTO.setLastName(member.getLastName());
        createMemberDTO.setPhoneNumber(member.getPhoneNumber());
        createMemberDTO.setLicensePlate(licensePlateDTO);
        createMemberDTO.setMemberAddressDTO(memberAddressDTO);
        createMemberDTO.setMembershipInfoDTO(membershipInfoDTO);

        return createMemberDTO;
    }
}
