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
import java.math.BigDecimal;

@Entity
@Table(name = "plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plan implements Serializable {

    @Id
    @Column(name = "plan_id")
    private Long planId;

    @Column(name = "plan_name")
    private String planName;

    @Column(name = "plan_description")
    private String planDesc;

    @Column(name = "plan_value")
    private BigDecimal planValue;
}
