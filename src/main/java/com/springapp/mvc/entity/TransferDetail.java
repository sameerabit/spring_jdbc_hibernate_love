package com.springapp.mvc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ssvh on 7/24/16.
 */


@Entity
public class TransferDetail implements Serializable {

    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = true)
    private Date date = new Date();

    private String reason;

    private FieldOfficer fieldOfficer;

    @ManyToOne
    public FieldOfficer getFieldOfficer() {
        return fieldOfficer;
    }

    public void setFieldOfficer(FieldOfficer fieldOfficer) {
        this.fieldOfficer = fieldOfficer;
    }

    private Loan loan;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }


    @Basic
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
