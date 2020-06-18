package com.kbc.service;

import com.kbc.dao.jpa.RewardRepository;
import com.kbc.domain.Reward;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class RewardService {

    private static final Logger log = LoggerFactory.getLogger(RewardService.class);

    @Autowired
    private RewardRepository rewardRepository;



    public RewardService() {
    }

    public Reward createReward(Reward reward) {
        return rewardRepository.save(reward);
    }

    public List<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }
}
