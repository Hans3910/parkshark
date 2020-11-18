package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.people.Email;
import com.jawsome.parkshark.domain.instances.people.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void iCanSaveAMember() {
        //GIVEN
        Member member1 = new Member();
        member1.setFirstName("Alex");
        member1.setLastName("Schouten");
        member1.setEmail(new Email("alex@hotmail.com"));

        //WHEN
        repository.save(member1);
        //THEN
        Assertions.assertEquals(1, repository.count());
    }
}