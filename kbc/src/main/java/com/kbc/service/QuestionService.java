package com.kbc.service;

import com.kbc.dao.jpa.QuestionRepository;
import com.kbc.domain.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private static final Logger log = LoggerFactory.getLogger(QuestionService.class);

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionService() {
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
