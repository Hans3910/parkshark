package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.Division;
import com.jawsome.parkshark.domain.instances.address.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
