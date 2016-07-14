package com.springapp.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ssvh on 4/20/16.
 */
public class TransferDetailPK implements Serializable {
    private int fieldOfficerId;
    private int loanId;

    @Column(name = "FieldOfficer_id")
    @Id
    public int getFieldOfficerId() {
        return fieldOfficerId;
    }

    public void setFieldOfficerId(int fieldOfficerId) {
        this.fieldOfficerId = fieldOfficerId;
    }

    @Column(name = "Loan_id")
    @Id
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransferDetailPK that = (TransferDetailPK) o;

        if (fieldOfficerId != that.fieldOfficerId) return false;
        if (loanId != that.loanId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fieldOfficerId;
        result = 31 * result + loanId;
        return result;
    }
}
