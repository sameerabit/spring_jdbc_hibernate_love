package com.springapp.mvc.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity
public class Turn {
    private int id;
    private int fieldOfficerId;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public int getFieldOfficerId() {
        return fieldOfficerId;
    }

    public void setFieldOfficerId(int fieldOfficerId) {
        this.fieldOfficerId = fieldOfficerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Turn turn = (Turn) o;

        if (id != turn.id) return false;
        if (fieldOfficerId != turn.fieldOfficerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fieldOfficerId;
        return result;
    }
}
