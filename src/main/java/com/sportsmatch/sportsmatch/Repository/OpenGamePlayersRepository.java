package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.OpenGamePlayers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpenGamePlayersRepository extends JpaRepository<OpenGamePlayers, Long> {

    List<OpenGamePlayers> findAllByOpenGameId(Long openGameId);
}
