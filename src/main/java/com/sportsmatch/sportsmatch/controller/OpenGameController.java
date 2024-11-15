package com.sportsmatch.sportsmatch.controller;

import com.sportsmatch.sportsmatch.model.OpenGame;
import com.sportsmatch.sportsmatch.service.OpenGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("open-game")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class OpenGameController {

    private final OpenGameService openGameService;

    @PostMapping(path = "{userId}/{position}")
    public ResponseEntity<?> saveOpenGame(@RequestBody OpenGame openGame,
                                          @PathVariable(name = "userId") Long userId,
                                          @PathVariable(name = "position") Long position) {
        openGameService.createCasualGame(openGame, userId, position);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "participar/{userId}/{opengameId}/{position}")
    public ResponseEntity<?> participar(@PathVariable("userId") Long userId,
                                        @PathVariable("opengameId") Long opengameId,
                                        @PathVariable("position") Long position) {
        openGameService.participarJogo(userId, opengameId, position);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
