package com.sportsmatch.sportsmatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "opengame")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpenGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "opengame_id")
    private Long opengameId;

    @Column(name = "opengame_title")
    private String opengameTitle;

    @Column(name = "opengame_description")
    private String opengameDesc;

    @Column(name = "sport")
    private Long sport;

    @Column(name = "max_players")
    private Long maxPlayers;

    @Column(name = "opengame_date")
    private LocalDateTime opengameDay;

    @Column(name = "opengameLocation")
    private Long opengameLocation;
}
