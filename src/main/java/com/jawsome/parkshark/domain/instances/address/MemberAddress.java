package com.jawsome.parkshark.domain.instances.address;

import javax.persistence.*;

@Entity
@Table(name = "member_address")
public class MemberAddress extends Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "member_address_member_address_id_seq")
    @Column(name = "member_address_id")
    private int memberAddressId;

    public int getMemberAddressId() {
        return memberAddressId;
    }
}
