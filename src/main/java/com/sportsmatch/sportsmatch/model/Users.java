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
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Users implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_description")
    private String userDescription;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_actual_team")
    private Long userActualTeam;

    @Column(name = "user_address")
    private Long address;

    @Column(name = "user_favorite_position")
    private Long userFavPosition;

    @Column(name = "user_photo")
    private byte[] userPhoto;

    @Column(name = "active")
    private boolean active;

    private transient String addressStreet;
}
