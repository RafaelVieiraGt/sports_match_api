package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {

    @Query(nativeQuery = true, value = "select " +
            "g.* " +
            " from basegames bg," +
            "   games g," +
            "   team_lineup tl," +
            "   team t " +
            " where " +
            "   t.team_id = tl.team_id " +
            "   and tl.user_id = :userId" +
            "   and (bg.home_team = t.team_id or bg.home_team = t.team_id) " +
            "   and g.game_id = bg.game_id ")
    List<Games> getUserGames(@Param("userId") Long userId);
}
