package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Bank;
import com.springapp.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
