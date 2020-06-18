package com.kbc.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "user_answers")
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAnswers {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name="userid",foreignKey=@ForeignKey(name="answer_userid_fk"))
    private User user;

    @ManyToOne
    @JoinColumn(name="questionid",foreignKey=@ForeignKey(name="answer_questionid_fk"))
    private Question question;

    @JsonProperty("coupon")
    @Column
    private Integer choice;

    public UserAnswers() {
    }

    public UserAnswers(User user, Question question, Integer choice) {
        this.user = user;
        this.question = question;
        this.choice = choice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getChoice() {
        return choice;
    }

    public void setChoice(Integer choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserAnswers{");
        sb.append("user=").append(user);
        sb.append(", question=").append(question);
        sb.append(", choice=").append(choice);
        sb.append('}');
        return sb.toString();
    }
}
