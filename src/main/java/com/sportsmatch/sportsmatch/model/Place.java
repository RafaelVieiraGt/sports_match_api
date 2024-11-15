package com.sportsmatch.sportsmatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "place")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "place_description")
    private String placeDesc;

    @Column(name = "place_longitude")
    private Double placeLongitude;

    @Column(name = "place_latitude")
    private Double placeLatitude;

}
