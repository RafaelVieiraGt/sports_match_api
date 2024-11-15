package com.sportsmatch.sportsmatch.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EditPerfilDTO implements Serializable {
    private String nome;
    private String descricao;
    private String foto;
    private Long position;
}
