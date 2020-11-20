package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.instances.address.City;
import com.jawsome.parkshark.domain.instances.address.Country;
import com.jawsome.parkshark.domain.instances.people.Member;
import com.jawsome.parkshark.domain.repositories.CityRepository;
import com.jawsome.parkshark.domain.repositories.CountryRepository;
import com.jawsome.parkshark.domain.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private MemberRepository memberRepository;
    private CountryRepository countryRepository;
    private CityRepository cityRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, CountryRepository countryRepository, CityRepository cityRepository) {
        this.memberRepository = memberRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    public void createMember(Member member) {
        countryAndCityCheck(member);
        memberRepository.save(member);
    }

    private void countryAndCityCheck(Member member) {
        if (countryExists(member.getMemberAddress().getCity().getCountry())) {
            Country country = countryRepository.findById(member.getMemberAddress().getCity().getCountry().getCountryCode()).get();
            member.getMemberAddress().getCity().setCountry(country);
        }
        if(countryExists(member.getLicensePlate().getCountryCodeId())){
            Country country = countryRepository.findById(member.getLicensePlate().getCountryCodeId().getCountryCode()).get();
            member.getLicensePlate().setCountryCodeId(country);
        }
        if(cityExists(member.getMemberAddress().getCity())){
            City city = cityRepository.findById(member.getMemberAddress().getCity().getPostalCode()).get();
            member.getMemberAddress().setCity(city);
        }
    }

    public boolean countryExists(Country country) {
        return countryRepository.existsById(country.getCountryCode());
    }

    public boolean cityExists(City city){
        return cityRepository.existsById(city.getPostalCode());
    }
}
