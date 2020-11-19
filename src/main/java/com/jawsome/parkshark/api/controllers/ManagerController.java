package com.jawsome.parkshark.api.controllers;

import com.jawsome.parkshark.domain.instances.people.Manager;
import com.jawsome.parkshark.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
@RestController
@RequestMapping(path = "/manager")
public class ManagerController {
    private final Logger logger = LoggerFactory.getLogger(ManagerController.class);
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Manager> getAllAdmins(){
        logger.info("List of all manager was requested.");
        return new ArrayList<>(managerService.getAll());
    }
}
