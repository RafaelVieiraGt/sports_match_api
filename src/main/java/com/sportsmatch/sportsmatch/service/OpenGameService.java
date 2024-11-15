package com.sportsmatch.sportsmatch.service;

import com.sportsmatch.sportsmatch.Repository.OpenGamePlayersRepository;
import com.sportsmatch.sportsmatch.Repository.OpenGameRepository;
import com.sportsmatch.sportsmatch.model.OpenGame;
import com.sportsmatch.sportsmatch.model.OpenGamePlayers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenGameService {

    private final OpenGameRepository openGameRepository;
    private final OpenGamePlayersRepository openGamePlayersRepository;

    public void createCasualGame(OpenGame gamesDto, Long userId, Long position) {

        var game = openGameRepository.save(gamesDto);
        OpenGamePlayers openGamePlayers = new OpenGamePlayers();

        openGamePlayers.setOpenGameId(game.getOpengameId());

        if (position != null)
            openGamePlayers.setPosition(position);

        openGamePlayers.setUserId(userId);

        openGamePlayersRepository.save(openGamePlayers);

    }

    public void participarJogo(Long userId, Long opengameId, Long position) {
        OpenGame openGame = openGameRepository.findById(opengameId)
                .orElseThrow(() -> new RuntimeException("Jogo não disponível!"));

        List<OpenGamePlayers> gamePlayers = openGamePlayersRepository.findAllByOpenGameId(opengameId);

        for (var player : gamePlayers) {
            if (player.getUserId().equals(userId))
                throw new RuntimeException("Jogador já cadastrado!");
        }

        OpenGamePlayers newPlayer = new OpenGamePlayers();
        newPlayer.setOpenGameId(openGame.getOpengameId());
        newPlayer.setPosition(position);
        newPlayer.setUserId(userId);

        openGamePlayersRepository.save(newPlayer);
    }
}
