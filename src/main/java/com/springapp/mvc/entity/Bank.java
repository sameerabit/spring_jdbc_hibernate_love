package com.springapp.mvc.entity;

import javax.persistence.*;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity(name="Bank")
public class Bank {

    private int id;
    private String name;
    private String telNo;
    private String fax;
    private String address;
    private Byte status;
    private String updatedAt;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    @Basic
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        if (id != bank.id) return false;
        if (telNo != null ? !telNo.equals(bank.telNo) : bank.telNo != null) return false;
        if (fax != null ? !fax.equals(bank.fax) : bank.fax != null) return false;
        if (address != null ? !address.equals(bank.address) : bank.address != null) return false;
        if (status != null ? !status.equals(bank.status) : bank.status != null) return false;
        if (updatedAt != null ? !updatedAt.equals(bank.updatedAt) : bank.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (telNo != null ? telNo.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }


}
