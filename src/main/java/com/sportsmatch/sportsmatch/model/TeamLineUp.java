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
@Table(name = "team_lineup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamLineUp implements Serializable {

    @Id
    @Column(name = "lineup_id")
    private Long lineupId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "is_owner")
    private boolean isOwner;

    @Column(name = "active")
    private boolean active;

    @Column(name = "main_position")
    private Long mainPosition;
}
