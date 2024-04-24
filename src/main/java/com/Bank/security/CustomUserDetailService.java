package com.Bank.security;

import com.Bank.entity.Customer;
import com.Bank.exception.CustomException;
import com.Bank.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;
@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer loadUserByUsername(String customerPhone) throws UsernameNotFoundException {
        Customer customer=customerRepo.findByCustomerPhone(customerPhone).orElseThrow(()->new CustomException("Phone number not found"));
        return  customer;
    }
}
