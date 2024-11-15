package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.OpenGame;
import com.sportsmatch.sportsmatch.model.jpa.CasualGamesJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpenGameRepository extends JpaRepository<OpenGame, Long> {

    @Query(nativeQuery = true, value = "select \n" +
            "o.opengame_id, \n" +
            "o.opengame_title,\n" +
            "o.opengame_description,\n" +
            "s.sport_name ,\n" +
            "o.max_players,\n" +
            "pl.place_name,\n" +
            "pl.place_longitude,\n" +
            "pl.place_latitude,\n" +
            "count(op.user_id) as players,\n" +
            "s.sport_id," +
            "to_char(o.opengame_date, 'DD/MM/YYYY HH24:MI') as \"date\" \n" +
            "from opengame o,\n" +
            "place pl,\n" +
            "sports s,\n" +
            "opengame_players op \n" +
            "where \n" +
            "s.sport_id = o.sport \n" +
            "and pl.place_id = o.opengame_location \n" +
            "and op.opengame_id = o.opengame_id \n" +
            "group by " +
            "o.opengame_id,\n" +
            "o.opengame_title, \n" +
            "o.opengame_description,\n" +
            "s.sport_name ,\n" +
            "o.max_players,\n" +
            "pl.place_name,\n" +
            "pl.place_longitude,\n" +
            "pl.place_latitude, \n" +
            "s.sport_id," +
            "o.opengame_date")
    List<CasualGamesJPA> getAllGames();

    @Query(nativeQuery = true, value = "select \n" +
            "            o.opengame_id,\n" +
            "            o.opengame_title,\n" +
            "            o.opengame_description,\n" +
            "            s.sport_name ,\n" +
            "            o.max_players,\n" +
            "            pl.place_name,\n" +
            "            pl.place_longitude,\n" +
            "            pl.place_latitude,\n" +
            "            count(op.user_id) as players,\n" +
            "            s.sport_id,\n" +
            "            to_char(o.opengame_date, 'DD/MM/YYYY HH24:MI') as \"date\" \n" +
            "            from opengame o,\n" +
            "            place pl,\n" +
            "            sports s,\n" +
            "            opengame_players op \n" +
            "            where \n" +
            "            s.sport_id = o.sport \n" +
            "            and pl.place_id = o.opengame_location \n" +
            "            and op.opengame_id = o.opengame_id\n" +
            "            and op.user_id = :userId" +
            "            and o.opengame_date > now()\n" +
            "            group by \n" +
            "            o.opengame_id,\n" +
            "            o.opengame_title, \n" +
            "            o.opengame_description,\n" +
            "            s.sport_name ,\n" +
            "            o.max_players,\n" +
            "            pl.place_name,\n" +
            "            pl.place_longitude,\n" +
            "            pl.place_latitude, \n" +
            "            s.sport_id,\n" +
            "            o.opengame_date\n" +
            "            order by o.opengame_date asc\n" +
            "            limit 1")
    CasualGamesJPA getNextGame(@Param("userId") Long userId);
}
