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
public class User implements Serializable{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "userid")
    private long userid;

    @JsonProperty("email")
    @Column(nullable = false)
    private String email;

    @JsonProperty("name")
    @Column
    private String name;

    @JsonProperty("points")
    @Column
    private Integer points;

    public User() {
    }

    public User(String email, String name, Integer points) {
        this.email = email;
        this.name = name;
        this.points = points;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userid=").append(userid);
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}
