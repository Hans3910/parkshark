package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.divisions.Subdivision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubdivisionRepository extends CrudRepository<Subdivision, Integer> {
}
