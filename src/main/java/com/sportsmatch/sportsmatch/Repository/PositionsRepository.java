package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionsRepository extends JpaRepository<Positions, Long> {

    List<Positions> findAllBySport(Long sport);
}
