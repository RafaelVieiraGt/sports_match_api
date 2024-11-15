package com.sportsmatch.sportsmatch.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CasualGamesDTO implements Serializable {

    private Long openGameId;
    private String openGameTitle;
    private String openGameDescription;
    private String sport;
    private Long maxPlayers;
    private String placeName;
    private Double gameLongitude;
    private Double gameLatitude;
    private Long actualPlayers;
    private Double realDistance;
    private String urlPhoto;
    private Long sportId;
    private String date;
}
