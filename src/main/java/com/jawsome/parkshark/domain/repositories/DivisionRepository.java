package com.jawsome.parkshark.domain.repositories;


import com.jawsome.parkshark.domain.instances.divisions.Division;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionRepository extends CrudRepository<Division, Integer> {
    public List<Division> findByNewName(String newName);
}
