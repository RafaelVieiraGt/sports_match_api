package com.sportsmatch.sportsmatch.service;

import com.sportsmatch.sportsmatch.Repository.PositionsRepository;
import com.sportsmatch.sportsmatch.model.Positions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionsService {

    private final PositionsRepository positionsRepository;

    public List<Positions> findAll() {
        return positionsRepository.findAll();
    }

    public List<Positions> findBySport(Long sportId) {
        return positionsRepository.findAllBySport(sportId);
    }
}
