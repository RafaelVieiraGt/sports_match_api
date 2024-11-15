package com.sportsmatch.sportsmatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "opengame_players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpenGamePlayers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "opengame_players_id")
    private Long openGamePlayersId;

    @Column(name = "opengame_id")
    private Long openGameId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "position")
    private Long position;
}
