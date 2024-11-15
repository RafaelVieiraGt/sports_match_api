package com.sportsmatch.sportsmatch.controller;

import com.sportsmatch.sportsmatch.model.Place;
import com.sportsmatch.sportsmatch.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("place")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping()
    public ResponseEntity<Place> savePlace(@RequestBody Place place) {
        return new ResponseEntity<>(placeService.savePlace(place), HttpStatus.CREATED);
    }

    @GetMapping("all/{latitude}/{longitude}")
    public ResponseEntity<List<Place>> getAll(@PathVariable("latitude") double latitude,
                                              @PathVariable("longitude") double longitude) {
        return new ResponseEntity<>(placeService.getAll(latitude, longitude), HttpStatus.OK);
    }
}
