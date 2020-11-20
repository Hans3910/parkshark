package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.division.GetDivisionDTO;
import com.jawsome.parkshark.api.dto.people.CreateMemberDTO;
import com.jawsome.parkshark.api.dto.people.EmailDTO;
import com.jawsome.parkshark.api.dto.people.GetMemberDTO;
import com.jawsome.parkshark.domain.instances.address.City;
import com.jawsome.parkshark.domain.instances.address.Country;
import com.jawsome.parkshark.domain.instances.address.MemberAddress;
import com.jawsome.parkshark.domain.instances.divisions.Division;
import com.jawsome.parkshark.domain.instances.people.*;
import com.jawsome.parkshark.domain.repositories.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public GetMemberDTO convertMemberToGetMemberDto(Member member) {
        GetMemberDTO getMemberDTO = new GetMemberDTO();
        getMemberDTO.setMemberId(member.getMemberId());
        getMemberDTO.setFirstName(member.getFirstName());
        getMemberDTO.setLastName(member.getLastName());
        getMemberDTO.setLicensePlateNumber(member.getLicensePlate().getPlateNumber());
        getMemberDTO.setEmail(new EmailDTO(member.getEmail().getEmail()));
        getMemberDTO.setPhoneNumber(member.getPhoneNumber());
        getMemberDTO.setRegistrationDate(member.getLocalDateTime());
        return getMemberDTO;
    }

    public List<GetMemberDTO> convertMemberListToGetMemberDtoList(List<Member> memberList) {
        return memberList.stream().map(member -> convertMemberToGetMemberDto(member)).collect(Collectors.toList());
    }
}
