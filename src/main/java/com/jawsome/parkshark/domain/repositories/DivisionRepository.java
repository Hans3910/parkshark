package com.jawsome.parkshark.domain.repositories;


import com.jawsome.parkshark.domain.instances.Division;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends CrudRepository<Division, Integer> {
}
