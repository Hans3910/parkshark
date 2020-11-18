package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.division.CreateAndUpdateDivisionDTO;
import com.jawsome.parkshark.domain.instances.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {
    public Division convertCreateDivisionDtoToDivision(CreateAndUpdateDivisionDTO createAndUpdateDivisionDTO) {
        Division division = new Division(createAndUpdateDivisionDTO.getNewName(), createAndUpdateDivisionDTO.getOriginalName(), createAndUpdateDivisionDTO.getDirector());
        return division;
    }
}
