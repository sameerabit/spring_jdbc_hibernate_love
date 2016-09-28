package com.springapp.mvc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity
public class Turn {
    private int id;
    private FieldOfficer fieldOfficer;
    private String startTime;
    private String offTime;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne
    public FieldOfficer getFieldOfficer() {
        return fieldOfficer;
    }

    public void setFieldOfficer(FieldOfficer fieldOfficer) {
        this.fieldOfficer = fieldOfficer;
    }

    @Basic
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    public String getOffTime() {
        return offTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }
}
