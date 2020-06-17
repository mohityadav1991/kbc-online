package com.kbc.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "vendor")
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vendor {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "vendorid")
    private long vendorid;

    @JsonProperty("vendor")
    @Column(name = "vendordetails")
    private String vendordetails;

    public Vendor() {
    }

    public Vendor(String vendordetails) {
        this.vendordetails = vendordetails;
    }

    public String getVendordetails() {
        return vendordetails;
    }

    public void setVendordetails(String vendordetails) {
        this.vendordetails = vendordetails;
    }

    public long getVendorid() {
        return vendorid;
    }

    public void setVendorid(long vendorid) {
        this.vendorid = vendorid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vendor{");
        sb.append("vendorid=").append(vendorid);
        sb.append(", vendordetails='").append(vendordetails).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
