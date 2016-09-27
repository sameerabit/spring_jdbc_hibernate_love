package com.springapp.mvc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity
public class InstallmentPayment {

    private List<Credit> credit;
    private List<Cheque> cheque;

    public InstallmentPayment() {
        credit = new ArrayList<Credit>();
        cheque = new ArrayList<Cheque>();
    }

    private int id;
    private Loan loan;
    private BigDecimal interest;
    private BigDecimal capital;
    private BigDecimal fee;
    private String date;
    private Byte status;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    @Basic
    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    @Basic
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Basic
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstallmentPayment that = (InstallmentPayment) o;

        if (id != that.id) return false;
        if (interest != null ? !interest.equals(that.interest) : that.interest != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (fee != null ? !fee.equals(that.fee) : that.fee != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (interest != null ? interest.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (fee != null ? fee.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @OneToMany(cascade=CascadeType.PERSIST)
    public List<Credit> getCredit() {
        return credit;
    }

    public void setCredit(List<Credit> credit) {
        this.credit = credit;
    }

    @OneToMany(cascade=CascadeType.PERSIST)
    public List<Cheque> getCheque() {
        return cheque;
    }

    public void setCheque(List<Cheque> cheque) {
        this.cheque = cheque;
    }
}
