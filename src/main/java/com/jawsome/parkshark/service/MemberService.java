package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.instances.people.Member;
import com.jawsome.parkshark.domain.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createMember(Member member) {
        memberRepository.save(member);
    }
}
