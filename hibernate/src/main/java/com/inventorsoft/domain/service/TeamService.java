package com.inventorsoft.domain.service;

import com.inventorsoft.domain.model.Team;
import com.inventorsoft.domain.repository.TeamRepository;
import com.inventorsoft.domain.service.base.GeneralService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TeamService extends GeneralService<Team, Long> {

    TeamRepository teamRepository;

    public TeamService(TeamRepository repository) {
        super(repository);
        this.teamRepository = repository;
    }

    @Transactional(readOnly = true)
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Transactional
    public Team createTestTeam() {
        return teamRepository.save(new Team());
    }

}