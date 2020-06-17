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

    public Match() {
    }

    public Match(String answer) {
        this.answer = answer;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Match{");
        sb.append("matchid=").append(matchid);
        sb.append(", answer='").append(answer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}