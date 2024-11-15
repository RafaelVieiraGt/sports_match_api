package com.sportsmatch.sportsmatch.model;

public enum GameTypeEnum {
    CAMPEONATO(1L),
    AMISTOSO(2L),
    CASUAL(3L);

    private final Long id;

    // Construtor do enum
    GameTypeEnum(Long id) {
        this.id = id;
    }

    // Método para obter o Id
    public Long getId() {
        return id;
    }
}
