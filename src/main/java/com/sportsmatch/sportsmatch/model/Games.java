package com.sportsmatch.sportsmatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Games implements Serializable {

    @Id
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "game_title")
    private String gameTitle;

    @Column(name = "game_description")
    private String gameDesc;

    @Column(name = "game_day")
    private LocalDateTime gameDay;

    @Column(name = "game_type")
    private GameTypeEnum gameType;

    @Column(name = "championship")
    private Long champ;

    @Column(name = "sport")
    private Long sport;

    @Column(name = "game_location")
    private Long gameLoc;

    @Column(name = "game_duration")
    private Long gameDuration;
}
