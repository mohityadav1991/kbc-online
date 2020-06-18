package com.kbc.api.rest;

import com.kbc.domain.Match;
import com.kbc.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/kbc/v1/matches")
public class MatchResource {
    @Autowired
    private MatchService matchService;

    private static final Logger log = LoggerFactory.getLogger(MatchResource.class);

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createMatch(@RequestBody Match match,
                             HttpServletRequest request, HttpServletResponse response) {
        Match createdMatch = this.matchService.createMatch(match);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdMatch.getMatchid()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Match> getAllMatch(HttpServletRequest request, HttpServletResponse response){

        return this.matchService.getAllMatches();
    }
}
