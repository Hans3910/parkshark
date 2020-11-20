package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.address.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City,Integer> {
}
