package com.jawsome.parkshark.api.controllers;

import com.jawsome.parkshark.api.dto.division.CreateAndUpdateDivisionDTO;
import com.jawsome.parkshark.api.dto.division.GetDivisionDTO;
import com.jawsome.parkshark.api.mapper.DivisionMapper;
import com.jawsome.parkshark.domain.exceptions.MandatoryFieldException;
import com.jawsome.parkshark.domain.exceptions.NotUniqueArgumentException;
import com.jawsome.parkshark.domain.instances.Division;
import com.jawsome.parkshark.service.DivisionService;
import com.jawsome.parkshark.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.swagger.v3.oas.integration.StringOpenApiConfigurationLoader.LOGGER;

@RestController
@RequestMapping(path = "/division")
public class DivisionController {

    private DivisionMapper divisionMapper;
    private DivisionService divisionService;
    private ManagerService managerService;

    @Autowired
    public DivisionController(DivisionMapper divisionMapper, DivisionService divisionService, ManagerService managerService) {
        this.divisionMapper = divisionMapper;
        this.divisionService = divisionService;
        this.managerService = managerService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Division createDivision(@RequestBody CreateAndUpdateDivisionDTO createAndUpdateDivisionDTO, @RequestParam(required = false) int managerId) throws NotUniqueArgumentException, MandatoryFieldException {
        managerService.checkAdminId(managerId);
        LOGGER.info("Request to create a new division");
        Division division = divisionMapper.convertCreateDivisionDtoToDivision(createAndUpdateDivisionDTO);
        divisionService.createDivision(division);
        return division;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetDivisionDTO> getAllDivisions(@RequestParam(required = false) int managerId) {
        managerService.checkAdminId(managerId);
        LOGGER.info("Request to get all divisions");
        List<Division> divisions = divisionService.getAllDivisions();
        return divisionMapper.convertDivisionListToGetDivisionDtoList(divisions);
    }

}
