package com.kbc.dao.jpa;

import com.kbc.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface MatchRepository  extends JpaRepository<Match, Long>{
    List<Match> findAll();
}
