package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Expenses;
import com.springapp.mvc.entity.FieldOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expenses, Integer> {
}
