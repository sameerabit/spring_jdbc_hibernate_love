package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Bank;
import com.springapp.mvc.entity.Cash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRepository extends JpaRepository<Cash, Integer> {
}
