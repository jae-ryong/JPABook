package com.practice.jpa.chapter5;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    // 연관관계 설정
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    private String username;
}
