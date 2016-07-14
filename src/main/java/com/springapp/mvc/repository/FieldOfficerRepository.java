package com.springapp.mvc.repository;

import com.springapp.mvc.entity.FieldOfficer;
import com.springapp.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldOfficerRepository extends JpaRepository<FieldOfficer, Long> {
}
