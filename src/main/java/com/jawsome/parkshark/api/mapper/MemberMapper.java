package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.people.CreateMemberDTO;
import com.jawsome.parkshark.api.dto.people.GetMemberDTO;
import com.jawsome.parkshark.domain.instances.address.City;
import com.jawsome.parkshark.domain.instances.address.Country;
import com.jawsome.parkshark.domain.instances.address.MemberAddress;
import com.jawsome.parkshark.domain.instances.people.*;
import com.jawsome.parkshark.domain.repositories.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    private MembershipRepository membershipRepository;

    @Autowired
    public MemberMapper(MembershipRepository membershipRepository){
        this.membershipRepository = membershipRepository;
    }

    public Member toEntity(CreateMemberDTO createMemberDTO) {
        Member member = new Member();

        LicensePlate licensePlate = new LicensePlate();
        licensePlate.setPlateNumber(createMemberDTO.getLicensePlate().getPlateNumber());
        licensePlate.setCountryCodeId(createMemberDTO.getLicensePlate().getCountryCodeId());

        Country country = new Country();
        country.setCountryCode(createMemberDTO.getMemberAddress().getCity().getCountry().getCountryCode());

        City city = new City();
        city.setCityName(createMemberDTO.getMemberAddress().getCity().getCityName());
        city.setPostalCode(createMemberDTO.getMemberAddress().getCity().getPostalCode());
        city.setCountry(country);

        MemberAddress address = new MemberAddress();
        address.setStreetName(createMemberDTO.getMemberAddress().getStreetName());
        address.setStreetNumber(createMemberDTO.getMemberAddress().getStreetNumber());
        address.setCity(city);

        MembershipInfo membershipInfo = new MembershipInfo();
        MembershipInfo membershipInfoToFind = membershipRepository.findById(createMemberDTO.getMembershipInfo().getMembershipLevel()).get();
        membershipInfo.setMembershipLevel(membershipInfoToFind.getMembershipLevel());
        membershipInfo.setMonthlyCost(membershipInfoToFind.getMonthlyCost());
        membershipInfo.setPriceReduction(membershipInfoToFind.getPriceReduction());
        membershipInfo.setMaxParkingHours(membershipInfoToFind.getMaxParkingHours());

        member.setFirstName(createMemberDTO.getFirstName());
        member.setLastName(createMemberDTO.getLastName());
        member.setPhoneNumber(createMemberDTO.getPhoneNumber());
        member.setLicensePlate(licensePlate);
        member.setEmail(new Email(createMemberDTO.getEmail().getEmail()));
        member.setMemberAddress(address);
        member.setMembershipInfo(membershipInfo);

        return member;
    }

    public CreateMemberDTO toCreateDTO(Member member) {
        CreateMemberDTO createMemberDTO = new CreateMemberDTO();

        LicensePlateDTO licensePlateDTO = new LicensePlateDTO();
        licensePlateDTO.setPlateNumber(member.getLicensePlate().getPlateNumber());
        licensePlateDTO.setCountryCodeId(createMemberDTO.getLicensePlate().getCountryCodeId());

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
        createMemberDTO.setMemberAddress(memberAddressDTO);
        createMemberDTO.setMembershipLevel(membershipInfoDTO);

        return createMemberDTO;
    }
}
