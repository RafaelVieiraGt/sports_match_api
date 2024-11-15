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
@Table(name = "championshiprank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChampionshipRank implements Serializable {

    @Id
    @Column(name = "rank_id")
    private Long rankId;

    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "championship")
    private Long championship;

    @Column(name = "team_points")
    private Long teamPoints;

    @Column(name = "team_position")
    private Long teamPosition;
}
