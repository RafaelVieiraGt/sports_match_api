package com.sportsmatch.sportsmatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_cep")
    private Long addressCep;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_street")
    private String addressStreet;

    @Column(name = "address_uf")
    private String addressUf;

}
