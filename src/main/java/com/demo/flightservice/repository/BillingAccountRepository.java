package com.demo.flightservice.repository;

import com.demo.flightservice.model.BillingAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAccountRepository extends JpaRepository<BillingAccount, Long> {
    
}