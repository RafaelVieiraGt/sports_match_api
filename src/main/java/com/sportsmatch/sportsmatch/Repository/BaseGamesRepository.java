package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.BaseGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseGamesRepository extends JpaRepository<BaseGames, Long> {
}
