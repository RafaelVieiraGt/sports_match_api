package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.ChampionshipRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRankRepository extends JpaRepository<ChampionshipRank, Long> {
}
