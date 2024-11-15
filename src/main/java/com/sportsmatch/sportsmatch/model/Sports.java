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
@Table(name = "sports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sports implements Serializable {

    @Id
    @Column(name = "sport_id")
    private Long sportId;

    @Column(name = "sport_name")
    private String sportName;

    @Column(name = "sport_description")
    private String sportDesc;
}
