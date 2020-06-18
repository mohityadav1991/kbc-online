package com.kbc.dao.jpa;

import com.kbc.domain.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface RewardRepository extends JpaRepository<Reward, Long> {

    List<Reward> findAll();
}
