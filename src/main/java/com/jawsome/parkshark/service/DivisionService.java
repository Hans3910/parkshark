package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.instances.Division;
import com.jawsome.parkshark.domain.repositories.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public void createDivision(Division division) {
        divisionRepository.save(division);
    }
}
