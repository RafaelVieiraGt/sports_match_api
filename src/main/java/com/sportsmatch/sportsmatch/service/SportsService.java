package com.sportsmatch.sportsmatch.service;

import com.sportsmatch.sportsmatch.Repository.SportsRepository;
import com.sportsmatch.sportsmatch.model.Sports;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportsService {

    private final SportsRepository sportsRepository;

    public List<Sports> findAll() {
        return sportsRepository.findAll();
    }

}
