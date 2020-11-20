package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.exceptions.MandatoryFieldException;
import com.jawsome.parkshark.domain.exceptions.NotUniqueArgumentException;
import com.jawsome.parkshark.domain.instances.divisions.Division;
import com.jawsome.parkshark.domain.repositories.DivisionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DivisionServiceTest {

    @InjectMocks
    private DivisionService divisionService;

    @Mock
    private DivisionRepository divisionRepository;

    @Test
    public void whenGetAllDivisions_thenReturnTheListOfTheDivisions() {
        when(divisionRepository.findAll()).thenReturn(asList());

        assertThat(divisionService.getAllDivisions()).isEqualTo(asList());

    }

    @Test
    public void givenANewDivision_whenCreateADivision_thenThrowsMandatoryFieldException(){
        Division division = new Division();
        division.setNewName(null);
        division.setOriginalName("test");
        division.setDirector("test");

        assertThatThrownBy(()->divisionService.createDivision(division)).isInstanceOf(MandatoryFieldException.class);
    }

    @Test
    public void givenTwoNewDivisionWithTheSameNewName_whenAddThisTwoDivisionInDatabase_thenThrowsNotUniqueArgumentException() throws NotUniqueArgumentException {
        Division division1 = new Division();
        Division division2 = new Division();

        division1.setNewName("test");
        division1.setOriginalName("test1");
        division1.setDirector("test1");

        division2.setNewName("test");
        division2.setOriginalName("test2");
        division2.setDirector("test2");


        divisionService.createDivision(division1);
//        divisionService.createDivision(division2);

        assertThatThrownBy(()->divisionService.createDivision(division2)).isInstanceOf(NotUniqueArgumentException.class);

    }
}