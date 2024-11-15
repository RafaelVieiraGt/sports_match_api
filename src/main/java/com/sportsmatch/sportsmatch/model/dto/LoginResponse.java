package com.sportsmatch.sportsmatch.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class LoginResponse implements Serializable {
    private String token;
    private Long id;
    private String name;
    private String message;
}
