package com.jawsome.parkshark.api.mapper;

import com.jawsome.parkshark.api.dto.division.CreateAndUpdateDivisionDTO;
import com.jawsome.parkshark.api.dto.division.GetDivisionDTO;
import com.jawsome.parkshark.domain.instances.Division;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DivisionMapper {
    public Division convertCreateDivisionDtoToDivision(CreateAndUpdateDivisionDTO createAndUpdateDivisionDTO) {
        Division division = new Division();
        division.setNewName(createAndUpdateDivisionDTO.getNewName());
        division.setOriginalName(createAndUpdateDivisionDTO.getOriginalName());
        division.setDirector(createAndUpdateDivisionDTO.getDirector());
        return division;
    }

    public GetDivisionDTO convertDivisionToGetDivisionDto(Division division) {
        GetDivisionDTO getDivisionDTO = new GetDivisionDTO();
        getDivisionDTO.setNewName(division.getNewName());
        getDivisionDTO.setOriginalName(division.getOriginalName());
        getDivisionDTO.setDirector(division.getDirector());
        return getDivisionDTO;
    }

    public List<GetDivisionDTO> convertDivisionListToGetDivisionDtoList(List<Division> divisionList) {
        List<GetDivisionDTO> divisionDTOList = new ArrayList();
        return divisionList.stream().map(division -> convertDivisionToGetDivisionDto(division)).collect(Collectors.toList());
    }
}
