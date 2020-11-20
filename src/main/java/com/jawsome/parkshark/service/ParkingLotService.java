package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.instances.ContactPerson;
import com.jawsome.parkshark.domain.instances.ParkingLot;
import com.jawsome.parkshark.domain.instances.address.City;
import com.jawsome.parkshark.domain.instances.address.Country;
import com.jawsome.parkshark.domain.instances.divisions.Division;
import com.jawsome.parkshark.domain.instances.people.Member;
import com.jawsome.parkshark.domain.repositories.CityRepository;
import com.jawsome.parkshark.domain.repositories.CountryRepository;
import com.jawsome.parkshark.domain.repositories.MemberRepository;
import com.jawsome.parkshark.domain.repositories.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    private CountryRepository countryRepository;
    private CityRepository cityRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository, CountryRepository countryRepository, CityRepository cityRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    public void createParkingLot(ParkingLot parkingLot) {
        // countryAndCityCheck(parkingLot);
        parkingLotRepository.save(parkingLot);
    }

    //    private void countryAndCityCheck(ParkingLot parkingLot) {
//        if (countryExists(parkingLot.getParkingAddressId().getCity().getCountry())) {
//            Country country = countryRepository.findById(parkingLot.getParkingAddress().getCity().getCountry().getCountryCode()).get();
//            parkingLot.getParkingAddress().getCity().setCountry(country);
//        }
//        if (cityExists(parkingLot.getParkingAddress().getCity())) {
//            City city = cityRepository.findById(parkingLot.getParkingAddress().getCity().getPostalCode()).get();
//            parkingLot.getParkingAddress().setCity(city);
//        }
//        if (contactPersonExists(parkingLot.getContactPerson())){
//            ContactPerson contactPerson=P
//            parkingLot.getContactPerson()
//        }
//    }
    public List<ParkingLot> getAllParkingLots() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLotRepository.findAll().forEach(parkingLots::add);
        return parkingLots;
    }
//    public boolean contactPersonExists(ContactPerson contactPerson){
//        return parkingLotRepository.existsById(contactPerson.getContactPersonId());
//    }
}

