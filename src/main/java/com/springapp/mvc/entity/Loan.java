package com.springapp.mvc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity
public class Loan {

    private List<TransferDetail> transferDetails;

    public Loan(){
        transferDetails = new ArrayList<TransferDetail>();
    }

    private int id;
    private Integer number;
    private String date;
    private BigDecimal capital;
    private BigDecimal interest;
    private BigDecimal total;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Customer customer;

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Basic
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    @Basic
    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    @Basic
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        if (id != loan.id) return false;
        if (number != null ? !number.equals(loan.number) : loan.number != null) return false;
        if (capital != null ? !capital.equals(loan.capital) : loan.capital != null) return false;
        if (interest != null ? !interest.equals(loan.interest) : loan.interest != null) return false;
        if (total != null ? !total.equals(loan.total) : loan.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (interest != null ? interest.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "loan",cascade = CascadeType.PERSIST)
    public List<TransferDetail> getTransferDetails() {
        return transferDetails;
    }

    public void setTransferDetails(List<TransferDetail>  transferDetails) {
        this.transferDetails = transferDetails;
    }

}
