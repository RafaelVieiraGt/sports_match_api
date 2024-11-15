package com.sportsmatch.sportsmatch.service;

import com.sportsmatch.sportsmatch.Repository.TeamRepository;
import com.sportsmatch.sportsmatch.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public List<Team> getTeamsFeed() {
        return teamRepository.findAll();
    }

    public Team createTeam(Team team) {

        if (teamExists(team.getTeamName()))
            throw new RuntimeException("Time já cadastrado!");

        return teamRepository.save(team);
    }

    private boolean teamExists(String name) {
        var team = teamRepository.findByTeamName(name);

        return  team != null;
    }
}
