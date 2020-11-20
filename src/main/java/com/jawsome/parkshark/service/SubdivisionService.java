package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.exceptions.MandatoryFieldException;
import com.jawsome.parkshark.domain.instances.divisions.Subdivision;
import com.jawsome.parkshark.domain.repositories.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class SubdivisionService {

    private SubdivisionRepository subdivisionRepository;
    @Autowired
    public SubdivisionService(SubdivisionRepository subdivisionRepository) {
        this.subdivisionRepository = subdivisionRepository;
    }

    public void createSubdivision(Subdivision subdivision) throws MandatoryFieldException {
        subdivisionRepository.save(subdivision);
    }


}
