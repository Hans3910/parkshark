package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.division.CreateSubdivisionDTO;
import com.jawsome.parkshark.domain.instances.divisions.Division;
import com.jawsome.parkshark.domain.instances.divisions.Subdivision;
import com.jawsome.parkshark.domain.repositories.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubdivisionMapper {
    private DivisionRepository divisionRepository;
    @Autowired
    public SubdivisionMapper(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Subdivision convertCreateDivisionDtoToSubdivision(CreateSubdivisionDTO createSubdivisionDTO) {
        Division parentDivision = divisionRepository.findByNewName(createSubdivisionDTO.getParentDivisionNewName()).get(0);
        Subdivision subdivision = new Subdivision();
        subdivision.setNewName(createSubdivisionDTO.getNewName());
        subdivision.setOriginalName(createSubdivisionDTO.getOriginalName());
        subdivision.setDirector(createSubdivisionDTO.getDirector());
        subdivision.setParentDivisionId(parentDivision.getId());
        return subdivision;
    }
}
