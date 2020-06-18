package com.kbc.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "dbo", name = "Reward")
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reward implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "rewardid")
    private Long rewardid;

    @JsonProperty("points_threshold")
    @Column(nullable = false)
    private Integer points_threshold;

    @JoinColumn(name = "vendorid")
    @OneToOne(cascade = CascadeType.ALL)
    private Vendor vendor;

    @JsonProperty("coupon_type")
    @Column(nullable = false)
    private String coupon_type;

    public Reward() {
    }

    public Reward(Integer points_threshold, Vendor vendor, String coupon_type) {
        this.points_threshold = points_threshold;
        this.vendor = vendor;
        this.coupon_type = coupon_type;
    }

    public Long getRewardid() {
        return rewardid;
    }

    public void setRewardid(Long rewardid) {
        this.rewardid = rewardid;
    }

    public Integer getPoints_threshold() {
        return points_threshold;
    }

    public void setPoints_threshold(Integer points_threshold) {
        this.points_threshold = points_threshold;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getCoupon_type() {
        return coupon_type;
    }

    public void setCoupon_type(String coupon_type) {
        this.coupon_type = coupon_type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reward{");
        sb.append("rewardid=").append(rewardid);
        sb.append(", points_threshold=").append(points_threshold);
        sb.append(", vendor=").append(vendor);
        sb.append(", coupon_type='").append(coupon_type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
