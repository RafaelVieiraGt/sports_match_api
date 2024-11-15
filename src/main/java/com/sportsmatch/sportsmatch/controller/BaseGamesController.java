package com.sportsmatch.sportsmatch.controller;

import com.sportsmatch.sportsmatch.model.dto.CasualGamesDTO;
import com.sportsmatch.sportsmatch.service.BaseGamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("base-games")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class BaseGamesController {

    private final BaseGamesService baseGamesService;

    @GetMapping("all/{latitude}/{longitude}")
    public ResponseEntity<List<CasualGamesDTO>> getAllGames(@PathVariable("latitude") Double latitude,
                                                            @PathVariable("longitude") Double longitude) {
        return new ResponseEntity<>(baseGamesService.getCasualGames(latitude, longitude), HttpStatus.OK);
    }

    @GetMapping("next-game/{latitude}/{longitude}")
    public ResponseEntity<CasualGamesDTO> getNextGame(@PathVariable("latitude") Double latitude,
                                                      @PathVariable("longitude") Double longitude) {
        return new ResponseEntity<>(baseGamesService.findNextGame(latitude, longitude), HttpStatus.OK);
    }

}
