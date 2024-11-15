package com.sportsmatch.sportsmatch.controller;

import com.sportsmatch.sportsmatch.model.Positions;
import com.sportsmatch.sportsmatch.service.PositionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("position")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class PositionController {

    private final PositionsService positionsService;

    @GetMapping("all")
    public ResponseEntity<List<Positions>> findAll() {
        return new ResponseEntity<>(positionsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{sportId}")
    public ResponseEntity<List<Positions>> findBySportId(@PathVariable("sportId") Long sportId) {
        return new ResponseEntity<>(positionsService.findAll(), HttpStatus.OK);
    }
}
