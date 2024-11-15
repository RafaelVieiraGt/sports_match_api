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

@Entity
@Table(name = "basegames")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseGames implements Serializable {

    @Id
    @Column(name = "base_game_id")
    private Long baseGameId;

    @Column(name = "home_team")
    private Long homeTeam;

    @Column(name = "visitor_team")
    private Long visitorTeam;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "game_type")
    private Long gameType;
}
