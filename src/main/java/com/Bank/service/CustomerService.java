package com.Bank.service;

import com.Bank.entity.Account;
import com.Bank.payload.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public CustomerDto addcustomer(CustomerDto customerDto,int branchCode);
    public ResponseEntity<?> getCustomerbyCustomerId(int customerId);
    public ResponseEntity<?> getCustomerByAccountNumber(int accountNumber);
    public List<CustomerDto> getall();
    public String deleteCustomer(int customerId);
    public Account deposite(int amount, int accountNumber);
    public Account withdrawl(int amount, int accountNumber);
}
