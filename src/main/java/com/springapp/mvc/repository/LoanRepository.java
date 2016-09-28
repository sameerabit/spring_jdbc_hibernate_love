package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Loan;
import com.springapp.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
