package com.springapp.mvc.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity
public class TransferDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reason;
    private String date;

    private FieldOfficer fieldOfficer;

    @Id
    @ManyToOne
    public FieldOfficer getFieldOfficer() {
        return fieldOfficer;
    }

    public void setFieldOfficer(FieldOfficer fieldOfficer) {
        this.fieldOfficer = fieldOfficer;
    }

    private Loan loan;

    @Id
    @ManyToOne()
    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }


    @Basic
    public String getReason() {
        return reason;
    }//

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
