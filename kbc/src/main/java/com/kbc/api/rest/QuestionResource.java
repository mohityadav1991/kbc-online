package com.kbc.api.rest;

import com.kbc.domain.Question;
import com.kbc.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/example/v1/questions")
public class QuestionResource {

    @Autowired
    private QuestionService questionService;

    private static final Logger log = LoggerFactory.getLogger(QuestionResource.class);

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createQuestion(@RequestBody Question question,
                             HttpServletRequest request, HttpServletResponse response) {
        Question createdQuestion = this.questionService.createQuestion(question);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdQuestion.getQuestionid()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Question> getAllQuestion(HttpServletRequest request, HttpServletResponse response){

        return this.questionService.getAllQuestions();
    }
}
