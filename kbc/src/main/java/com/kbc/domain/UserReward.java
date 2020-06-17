package com.kbc.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "dbo", name = "user_has_rewards")
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserReward implements Serializable{

    @ManyToOne
    @JoinColumn(name="userid",foreignKey=@ForeignKey(name="userid_fk"))
    private User user;

    @ManyToOne
    @JoinColumn(name="rewardid",foreignKey=@ForeignKey(name="rewardid_fk"))
    private Reward reward;

    @JsonProperty("coupon")
    @Column
    private String coupon;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserReward{");
        sb.append("user=").append(user);
        sb.append(", reward=").append(reward);
        sb.append(", coupon='").append(coupon).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
