package com.springapp.mvc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ssvh on 3/4/16.
 */
@Entity(name="Branch")
public class Branch {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;


    private String address;


    private int telNo;


    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = true, updatable = false)
    private Date createdAt = new Date();

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = true)
    private Date updatedAt = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelNo() {
        return telNo;
    }

    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
