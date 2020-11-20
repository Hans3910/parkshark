package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.ParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends CrudRepository <ParkingLot, Integer> {

}
