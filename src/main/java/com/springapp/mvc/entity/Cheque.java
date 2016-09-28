package com.springapp.mvc.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity
@Proxy(lazy = false)
public class Cheque {
    private int id;
    private InstallmentPayment installmentPayment;
    private BigDecimal amount;
    private int number;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Basic
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cheque cheque = (Cheque) o;

        if (id != cheque.id) return false;

        if (amount != null ? !amount.equals(cheque.amount) : cheque.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @ManyToOne
    public InstallmentPayment getInstallmentPayment() {
        return installmentPayment;
    }

    public void setInstallmentPayment(InstallmentPayment installmentPayment) {
        this.installmentPayment = installmentPayment;
    }

    @Basic
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
