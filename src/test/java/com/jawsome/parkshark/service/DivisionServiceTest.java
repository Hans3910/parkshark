package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.exceptions.MandatoryFieldException;
import com.jawsome.parkshark.domain.instances.Division;
import com.jawsome.parkshark.domain.repositories.DivisionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class DivisionServiceTest {

    @InjectMocks
    DivisionService divisionService;

    @Mock
    private DivisionRepository divisionRepository;

    @Test
    void givenANewDivision_whenCreateADivision_thenThrowsMandatoryFieldException() {
        Division division = new Division();
        division.setNewName(null);
        division.setOriginalName("test");
        division.setDirector("test");

//        when(divisionService)

        Assertions.assertThrows(MandatoryFieldException.class, () -> divisionService.createDivision(division));


    }
}