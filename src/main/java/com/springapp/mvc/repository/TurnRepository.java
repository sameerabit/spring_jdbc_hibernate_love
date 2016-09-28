package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Bank;
import com.springapp.mvc.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnRepository extends JpaRepository<Turn, Integer> {
}
