package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Customer;
import com.springapp.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
