package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.people.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository <Member, Integer> {

}
