package com.jawsome.parkshark.api.controllers;

import com.jawsome.parkshark.api.dto.division.CreateAndUpdateDivisionDTO;
import com.jawsome.parkshark.api.mapper.DivisionMapper;
import com.jawsome.parkshark.domain.instances.Division;
import com.jawsome.parkshark.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static io.swagger.v3.oas.integration.StringOpenApiConfigurationLoader.LOGGER;

@RestController
@RequestMapping(path = "/division")
public class DivisionController {

    private DivisionMapper divisionMapper;
    private DivisionService divisionService;

    @Autowired
    public DivisionController(DivisionMapper divisionMapper, DivisionService divisionService) {
        this.divisionMapper = divisionMapper;
        this.divisionService = divisionService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Division createDivision(@RequestBody CreateAndUpdateDivisionDTO createAndUpdateDivisionDTO) {
        LOGGER.info("Request to create a new division");
        Division division = divisionMapper.convertCreateDivisionDtoToDivision(createAndUpdateDivisionDTO);
        divisionService.createDivision(division);
        return division;
    }

}
