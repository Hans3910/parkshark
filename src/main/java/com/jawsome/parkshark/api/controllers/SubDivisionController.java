package com.jawsome.parkshark.api.controllers;

import com.jawsome.parkshark.api.dto.division.CreateSubdivisionDTO;
import com.jawsome.parkshark.api.mapper.SubdivisionMapper;
import com.jawsome.parkshark.domain.exceptions.MandatoryFieldException;
import com.jawsome.parkshark.domain.instances.divisions.Subdivision;
import com.jawsome.parkshark.service.ManagerService;
import com.jawsome.parkshark.service.SubdivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static io.swagger.v3.oas.integration.StringOpenApiConfigurationLoader.LOGGER;

@RestController
@RequestMapping(path = "/subdivision")
public class SubDivisionController {
    private SubdivisionMapper subdivisionMapper;
    private SubdivisionService subdivisionService;
    private ManagerService managerService;

    @Autowired
    public SubDivisionController(SubdivisionMapper subdivisionMapper, SubdivisionService subdivisionService, ManagerService managerService) {
        this.subdivisionMapper = subdivisionMapper;
        this.subdivisionService = subdivisionService;
        this.managerService = managerService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Subdivision createDivision(@RequestBody CreateSubdivisionDTO createSubdivisionDTO, @RequestParam(required = false) int managerId) throws MandatoryFieldException {
        managerService.checkAdminId(managerId);
        LOGGER.info("Request to create a new subdivision");
        Subdivision subdivision = subdivisionMapper.convertCreateDivisionDtoToSubdivision(createSubdivisionDTO);
        subdivisionService.createSubdivision(subdivision);
        return subdivision;
    }
}
