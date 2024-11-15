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
import java.time.LocalDateTime;

@Entity
@Table(name = "userplanhistoric")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserPlanHistoric implements Serializable {

    @Id
    @Column(name = "hitoric_id")
    private Long historicId;

    @Column(name = "plan_id")
    private Long planId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date_sign")
    private LocalDateTime dateSign;
}
