package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.address.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, String> {
}
