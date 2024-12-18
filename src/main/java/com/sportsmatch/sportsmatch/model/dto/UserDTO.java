package com.sportsmatch.sportsmatch.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserDTO implements Serializable {
    private String name;
    private String email;
    private String password;
    private Long position;
    private String cep;

}
