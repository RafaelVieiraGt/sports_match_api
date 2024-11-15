package com.sportsmatch.sportsmatch.model.jpa;

public interface CasualGamesJPA {

    Long getOpengameId();
    String getOpengameTitle();
    String getOpengameDescription();
    String getSportName();
    Long getMaxPlayers();
    String getPlaceName();
    Double getPlaceLongitude();
    Double getPlaceLatitude();
    Long getPlayers();
    Long getSportId();
    String getDate();
}
