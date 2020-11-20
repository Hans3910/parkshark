package com.jawsome.parkshark.api.controllers;


import com.jawsome.parkshark.api.dto.division.GetDivisionDTO;
import com.jawsome.parkshark.api.dto.parkingLot.CreateParkingLotDTO;
import com.jawsome.parkshark.api.dto.parkingLot.GetParkingLotDTO;
import com.jawsome.parkshark.api.mapper.ParkingLotMapper;
import com.jawsome.parkshark.domain.instances.ParkingLot;
import com.jawsome.parkshark.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.swagger.v3.oas.integration.StringOpenApiConfigurationLoader.LOGGER;

@RestController
@RequestMapping(path = "/parkinglot")
public class ParkingLotController {

    private ParkingLotService parkingLotService;
    private ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotDTO createParkingLotDTO) {
        LOGGER.info("Register a parking lot");
        ParkingLot parkingLot = parkingLotMapper.convertParkingLotDtoToParkingLot(createParkingLotDTO);
        parkingLotService.createParkingLot(parkingLot);
        return parkingLot;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetParkingLotDTO> getAllParkingLots(@RequestParam(required = false) int managerId) {
        LOGGER.info("Request to get all parking lots");
        List<ParkingLot> parkingLots = parkingLotService.getAllParkingLots();
        return parkingLotMapper.convertParkingLotListToParkingLotDtoList(parkingLots);
    }
}
