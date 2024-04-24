package com.Bank.repository;

import com.Bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    @Query("SELECT c FROM Customer c WHERE c.account.accountNumber = :accountNumber")
    public Optional<Customer> getCustomerByAccountNumber(int accountNumber);
    public Optional<Customer>findByCustomerPhone(String customerPhone);
}
