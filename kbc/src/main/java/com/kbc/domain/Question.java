package com.kbc.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "dbo", name = "User")
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question implements Serializable{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "questionid")
    private Long questionid;

    @JsonProperty("question")
    @Column(name = "question")
    private String question;

    @JsonProperty("answer")
    @Column(name = "answer")
    private Integer answer;

    public Question() {
    }

    public Question(String question, Integer answer) {
        this.question = question;
        this.answer = answer;
    }

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Question{");
        sb.append("questionid=").append(questionid);
        sb.append(", question='").append(question).append('\'');
        sb.append(", answer=").append(answer);
        sb.append('}');
        return sb.toString();
    }
}
