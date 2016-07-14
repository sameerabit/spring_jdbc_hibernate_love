package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Bank;
import com.springapp.mvc.entity.TransferDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferDetailRepository extends JpaRepository<TransferDetail, Long> {
}
