package com.sportsmatch.sportsmatch.service;

import com.sportsmatch.sportsmatch.Repository.PlaceRepository;
import com.sportsmatch.sportsmatch.model.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final BaseGamesService baseGamesService;
    public Place savePlace(Place place) {

        if (place.getPlaceLatitude() == null ||
            place.getPlaceLongitude() == null)
            throw new RuntimeException("Longitude e Latitude não podem ser nulos!");

       return placeRepository.save(place);
    }

    public List<Place> getAll(double latitude, double longitude) {
        List<Place> allPlaces = placeRepository.findAll();
        List<Place> selectedPlaces = new ArrayList<>();

        for (var place : allPlaces) {
            if (baseGamesService.calcularDistancia(latitude, longitude, place.getPlaceLatitude(), place.getPlaceLongitude()) < 30) {
                selectedPlaces.add(place);
            }
        }

        return selectedPlaces;
    }
}
