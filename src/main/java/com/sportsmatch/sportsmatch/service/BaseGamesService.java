package com.sportsmatch.sportsmatch.service;

import com.sportsmatch.sportsmatch.Repository.OpenGamePlayersRepository;
import com.sportsmatch.sportsmatch.Repository.OpenGameRepository;
import com.sportsmatch.sportsmatch.model.*;
import com.sportsmatch.sportsmatch.model.dto.CasualGamesDTO;
import com.sportsmatch.sportsmatch.model.jpa.CasualGamesJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseGamesService {

    private final OpenGameRepository openGameRepository;
    private final OpenGamePlayersRepository openGamePlayersRepository;

    public OpenGame createCasualGame(OpenGame gamesDto, Long userId, Long position) {

        var game = openGameRepository.save(gamesDto);
        OpenGamePlayers openGamePlayers = new OpenGamePlayers();

        openGamePlayers.setOpenGameId(game.getOpengameId());

        if (position != null)
            openGamePlayers.setPosition(position);

        openGamePlayers.setUserId(userId);

        openGamePlayersRepository.save(openGamePlayers);

        return game;

    }

    public List<CasualGamesDTO> getCasualGames (Double userLatitude, Double userLongitude) {

        if (userLatitude.equals(0D) || userLongitude.equals((0D)))
            throw new RuntimeException("Erro ao obter latitude");

        List<CasualGamesJPA> allGames = openGameRepository.getAllGames();
        List<CasualGamesDTO> allGamesDTO = new ArrayList<>();

        for (var jpa : allGames) {
            if (calcularDistancia(userLatitude, userLongitude, jpa.getPlaceLatitude(), jpa.getPlaceLongitude())  <= 30L) {
                allGamesDTO.add(new CasualGamesDTO(
                        jpa.getOpengameId(),
                        jpa.getOpengameTitle(),
                        jpa.getOpengameDescription(),
                        jpa.getSportName(),
                        jpa.getMaxPlayers(),
                        jpa.getPlaceName(),
                        jpa.getPlaceLongitude(),
                        jpa.getPlaceLatitude(),
                        jpa.getPlayers(),
                        calcularDistancia(userLatitude, userLongitude, jpa.getPlaceLatitude(), jpa.getPlaceLongitude()),
                        jpa.getSportName().equals("Futebol") ? "../../Assets/capa-fut.png"
                                : jpa.getSportName().equals("Basquete") ? "../../Assets/basquete-teste.png"
                                : "../../Assets/capa-volei.png",
                        jpa.getSportId(),
                        jpa.getDate()
                ));
            }
        }

        return allGamesDTO;

    }

    public Double calcularDistancia(Double lat1, Double lon1, Double lat2, Double lon2) {
        double R = 6371;
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Diferença das coordenadas
        double dlat = lat2Rad - lat1Rad;
        double dlon = lon2Rad - lon1Rad;

        // Fórmula de Haversine
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calcula a distância
        double distancia = R * c;

        return distancia;
    }

    public CasualGamesDTO findNextGame(Double userLatitude, Double userLongitude) {
        var jpa = openGameRepository.getNextGame();
        if (jpa != null) {
            return new CasualGamesDTO(
                    jpa.getOpengameId(),
                    jpa.getOpengameTitle(),
                    jpa.getOpengameDescription(),
                    jpa.getSportName(),
                    jpa.getMaxPlayers(),
                    jpa.getPlaceName(),
                    jpa.getPlaceLongitude(),
                    jpa.getPlaceLatitude(),
                    jpa.getPlayers(),
                    calcularDistancia(userLatitude, userLongitude, jpa.getPlaceLatitude(), jpa.getPlaceLongitude()),
                    jpa.getSportName().equals("Futebol") ? "../../Assets/capa-fut.png"
                            : jpa.getSportName().equals("Basquete") ? "../../Assets/basquete-teste.png"
                            : "../../Assets/capa-volei.png",
                    jpa.getSportId(),
                    jpa.getDate()
            );
        }

        return null;
    }
}
