package com.kbc.api.rest;

import com.kbc.KbcApplication;
import com.kbc.domain.Reward;
import com.kbc.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/example/v1/rewards")
public class RewardResource extends AbstractRestHandler{

    @Autowired
    private RewardService rewardService;

    private static final Logger log = LoggerFactory.getLogger(RewardResource.class);

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createHotel(@RequestBody Reward reward,
                            HttpServletRequest request, HttpServletResponse response) {
        System.out.println("here...."+reward.toString());
        Reward createdReward = this.rewardService.createReward(reward);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdReward.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Reward> getAllReward(HttpServletRequest request, HttpServletResponse response){

        return this.rewardService.getAllRewards();
    }
}
