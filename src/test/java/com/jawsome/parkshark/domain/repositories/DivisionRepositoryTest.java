package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.divisions.Division;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class DivisionRepositoryTest {
    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    void ICanCreateADivision() {
        Division division = new Division();
        division.setNewName("Fishtank Inc.");
        division.setOriginalName("Car parking Inc.");
        division.setDirector("John Doe");
        divisionRepository.save(division);
        Assertions.assertThat(divisionRepository.count()).isEqualTo(1);
    }
}