package com.sportsmatch.sportsmatch.controller;

import com.sportsmatch.sportsmatch.Repository.SportsRepository;
import com.sportsmatch.sportsmatch.model.Sports;
import com.sportsmatch.sportsmatch.service.SportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sports")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class SportsController {

    private final SportsService sportsService;

    @GetMapping()
    public ResponseEntity<List<Sports>> findAll() {
        return new ResponseEntity<>(sportsService.findAll(), HttpStatus.OK);
    }
}
