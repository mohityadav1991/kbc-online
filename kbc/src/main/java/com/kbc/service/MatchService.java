package com.kbc.service;

import com.kbc.dao.jpa.MatchRepository;
import com.kbc.domain.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private static final Logger log = LoggerFactory.getLogger(MatchService.class);

    @Autowired
    private MatchRepository matchRepository;



    public MatchService() {
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
}
