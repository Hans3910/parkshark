package com.jawsome.parkshark.api.controllers;

import com.jawsome.parkshark.api.dto.people.CreateMemberDTO;
import com.jawsome.parkshark.api.dto.people.GetMemberDTO;
import com.jawsome.parkshark.api.mapper.MemberMapper;
import com.jawsome.parkshark.domain.instances.people.Member;
import com.jawsome.parkshark.service.ManagerService;
import com.jawsome.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.swagger.v3.oas.integration.StringOpenApiConfigurationLoader.LOGGER;


@RestController
@RequestMapping(path = "/member")
public class MemberController {

    private MemberService memberService;
    private ManagerService managerService;
    private MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberService memberService, ManagerService managerService, MemberMapper memberMapper){
        this.memberService = memberService;
        this.managerService = managerService;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetMemberDTO> getAllMembers(@RequestParam(required = false) int managerId){
        managerService.checkAdminId(managerId);
        LOGGER.info("get all members");
        List<Member> members = memberService.getAllMembers();
        return memberMapper.convertMemberListToGetMemberDtoList(members); 
    }
}
