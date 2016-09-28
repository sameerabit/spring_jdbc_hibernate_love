package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Cheque;
import com.springapp.mvc.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChequeRepository extends JpaRepository<Cheque, Integer> {
}
