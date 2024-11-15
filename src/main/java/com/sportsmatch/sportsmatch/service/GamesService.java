package com.sportsmatch.sportsmatch.service;

import com.sportsmatch.sportsmatch.Repository.GamesRepository;
import com.sportsmatch.sportsmatch.Repository.UsersRepository;
import com.sportsmatch.sportsmatch.model.Games;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamesService {

    private final GamesRepository gamesRepository;
    private final UserService userService;

    public Games createGame(Games game) {
        return gamesRepository.save(game);
    }

    public List<Games> getUserGames(Long userId) {

        var user = userService.findById(userId);

        if (user == null)
            throw new RuntimeException("Usuário não encontrado!");

        return gamesRepository.getUserGames(userId);
    }
}
