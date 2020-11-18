package com.jawsome.parkshark.domain.instances.people;

import com.jawsome.parkshark.domain.instances.LicensePlate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(schema = "park-shark", name = "member")
public class Member extends Person {

    private LicensePlate licensePlate;
    private LocalDateTime localDateTime;

    @Id
    private int memberId;




}
