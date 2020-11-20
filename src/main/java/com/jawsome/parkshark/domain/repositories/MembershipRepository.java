package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.instances.people.MembershipInfo;
import com.jawsome.parkshark.domain.instances.people.MembershipLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends CrudRepository<MembershipInfo, MembershipLevel> {
}
