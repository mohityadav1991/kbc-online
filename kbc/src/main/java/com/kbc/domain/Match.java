package com.kbc.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "dbo", name = "match")
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Match implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "matchid")
    private long matchid;

    @JsonProperty("answer")
    @Column
    private String answer;


    @OneToMany(cascade = CascadeType.ALL,  mappedBy="match")
    public Set<Question> questions;

    public Match() {
    }

    public Match(String answer, Set<Question> questions) {
        this.answer = answer;
        this.questions = questions;
    }

    public long getMatchid() {
        return matchid;
    }

    public void setMatchid(long matchid) {
        this.matchid = matchid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}