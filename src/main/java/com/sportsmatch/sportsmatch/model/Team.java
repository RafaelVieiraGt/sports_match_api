package com.sportsmatch.sportsmatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team implements Serializable {

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "team_description")
    private String teamDescription;

    @Column(name = "team_avatar")
    private byte[] teamAvatar;

    @Column(name = "team_max_members")
    private Long teamMaxMembers;

    @Column(name = "team_sport")
    private Long teamSport;
}
