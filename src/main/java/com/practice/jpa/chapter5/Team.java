package com.practice.jpa.chapter5;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Team {
    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;
}
