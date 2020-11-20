package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.address.City;
import com.jawsome.parkshark.domain.instances.address.Country;
import com.jawsome.parkshark.domain.instances.address.MemberAddress;
import com.jawsome.parkshark.domain.instances.people.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;
    @Autowired
    private CountryRepository countryRepository;

    @Test
    void iCanSaveAMember() {
        //GIVEN
        Member member1 = new Member();
        member1.setFirstName("Alex");
        member1.setLastName("Schouten");
        member1.setEmail(new Email("alex@hotmail.com"));

        //WHEN
        repository.save(member1);
        //THEN
        Assertions.assertEquals(1, repository.count());
    }

    @Test
    void iCanSaveAMemberWithALicensePlate() {
        Assertions.assertEquals(0, repository.count());

        //GIVEN
        Country country = new Country();
        country.setCountryCode("AB");
        country.setCountry("Alphabet");
        countryRepository.save(country);
        Country managedCountry = countryRepository.findById("AB").get();

        City city = new City();
        city.setCountry(managedCountry);
        city.setCityName("New City");
        city.setPostalCode(1000);
        MembershipInfo membershipInfo = new MembershipInfo();
        membershipInfo.setMembershipLevel(MembershipLevel.BRONZE);

        LicensePlate licensePlate = new LicensePlate();
        licensePlate.setCountryCodeId(managedCountry);
        licensePlate.setPlateNumber("abc123");
        //licensePlate.setVehicleId(1234); <= this is the ID of the licenseplate

        Member member1 = new Member();

        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setCity(city);
        memberAddress.setStreetName("My street");
        memberAddress.setStreetNumber("5");

        member1.setFirstName("Alex");
        member1.setLastName("Schouten");
        member1.setEmail(new Email("alex@hotmail.com"));
        member1.setLicensePlate(licensePlate);
        member1.setMemberAddress(memberAddress);
        member1.setMembershipInfo(membershipInfo);

        //WHEN
        Member savedMember = repository.save(member1);
        //THEN
        Assertions.assertEquals(1, repository.count());
        Assertions.assertEquals("abc123",
                repository.findById(savedMember.getMemberId()).get()
                        .getLicensePlate().getPlateNumber());
    }
}