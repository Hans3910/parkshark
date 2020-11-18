package com.jawsome.parkshark.api.controllers;

import com.jawsome.parkshark.api.dto.people.CreateMemberDTO;
import com.jawsome.parkshark.api.mapper.MemberMapper;
import com.jawsome.parkshark.domain.instances.people.Member;
import com.jawsome.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static io.swagger.v3.oas.integration.StringOpenApiConfigurationLoader.LOGGER;


@RestController
@RequestMapping(path = "/member")
public class MemberController {

    private MemberService memberService;
    private MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberService memberService, MemberMapper memberMapper){
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Member createMember(@RequestBody CreateMemberDTO createMemberDTO){
        LOGGER.info("Created a member");
        Member member = memberMapper.toEntity(createMemberDTO);
        memberService.createMember(member);
        return member;
    }
}
