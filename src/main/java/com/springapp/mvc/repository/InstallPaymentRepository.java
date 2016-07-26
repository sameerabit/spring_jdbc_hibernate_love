package com.springapp.mvc.repository;

import com.springapp.mvc.entity.InstallmentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ssvh on 7/24/16.
 */
public interface InstallPaymentRepository extends JpaRepository<InstallmentPayment,Integer> {
}
