package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.CreateDivisionDTO;
import com.jawsome.parkshark.domain.instances.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {
    public Division convertCreateDivisionDtoToDivision(CreateDivisionDTO createDivisionDTO) {
        Division division = new Division(createDivisionDTO.getNewName(), createDivisionDTO.getOriginalName(), createDivisionDTO.getDirector());
        return division;
    }
}
