package com.inventorsoft.domain.service;

import com.inventorsoft.domain.model.Match;
import com.inventorsoft.domain.repository.MatchRepository;
import com.inventorsoft.domain.service.base.GeneralService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MatchService extends GeneralService<Match, Long> {

    MatchRepository matchRepository;

    public MatchService(MatchRepository repository) {
        super(repository);
        this.matchRepository = repository;
    }

    @Transactional(readOnly = true)
    public List<Match> getAll() {
        return matchRepository.findAll();
    }

    @Transactional
    public Match createTestMatch() {
        return matchRepository.save(new Match());
    }

}