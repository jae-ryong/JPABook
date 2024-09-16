package com.practice.jpa.chapter4;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MEMBER")
@Data
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;
}
