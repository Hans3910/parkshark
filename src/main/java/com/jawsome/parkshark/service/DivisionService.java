package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.exceptions.MandatoryFieldException;
import com.jawsome.parkshark.domain.exceptions.NotUniqueArgumentException;
import com.jawsome.parkshark.domain.instances.Division;
import com.jawsome.parkshark.domain.repositories.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DivisionService {

    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public void createDivision(Division division) throws MandatoryFieldException, NotUniqueArgumentException {
        if (division.getNewName() == null || division.getOriginalName() == null || division.getDirector() == null) {
            throw new MandatoryFieldException("This field is mandatory");
        }
        if (!divisionRepository.existsByNewName(division.getNewName())){
            throw new NotUniqueArgumentException(Division.class, division.getNewName(), division.getNewName());
        }
        divisionRepository.save(division);
    }

    public List<Division> getAllDivisions() {
        List<Division> divisions = new ArrayList<>();
        divisionRepository.findAll().forEach(divisions::add);
        return divisions;
    }
}
