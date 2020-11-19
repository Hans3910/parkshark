package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.repositories.DivisionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DivisionServiceTest2 {

    @InjectMocks
    private DivisionService divisionService;

    @Mock
    private DivisionRepository divisionRepository;

    @Test
    public void thisIsATest() {
        when(divisionRepository.findAll()).thenReturn(asList());

        assertThat(divisionService.getAllDivisions()).isEqualTo(asList());

    }
}