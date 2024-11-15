package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.TeamLineUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamLineupRepository extends JpaRepository<TeamLineUp, Long> {
}
