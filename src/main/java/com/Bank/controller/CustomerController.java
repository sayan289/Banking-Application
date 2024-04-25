package com.Bank.controller;

import com.Bank.payload.CustomerDto;
import com.Bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/add/{branchCode}")
    public ResponseEntity<?> createcustomer(@RequestBody CustomerDto customerDto,@PathVariable int branchCode)
    {
        return new ResponseEntity<>(customerService.addcustomer(customerDto,branchCode), HttpStatus.OK);
    }
    @GetMapping("/fetch/{customerId}")
    public ResponseEntity<?> getCustomerbyCustomerId(@PathVariable int customerId)
    {
        return new ResponseEntity<>(customerService.getCustomerbyCustomerId(customerId),HttpStatus.OK);
    }
    @GetMapping("/fetch/account/{accountNumber}")
    public ResponseEntity<?>getCustomerByAccountId(@PathVariable int accountNumber)
    {
        return new ResponseEntity<>(customerService.getCustomerByAccountNumber(accountNumber),HttpStatus.OK);
    }
    @GetMapping("/fetch")
    public ResponseEntity<?> getall()
    {
        return new ResponseEntity<>(customerService.getall(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<?>deleteCustomer(@PathVariable int customerId)
    {
        return new ResponseEntity<>(customerService.deleteCustomer(customerId),HttpStatus.OK);
    }
    @PostMapping("/deposite/{amount}/{accountNumber}")
    public ResponseEntity<?> deposite(@PathVariable int amount,@PathVariable int accountNumber)
    {
        return new ResponseEntity<>(customerService.deposite(amount,accountNumber),HttpStatus.OK);
    }
    @PostMapping("/withdrawl/{amount}")
    public ResponseEntity<?> withdrawl(@PathVariable int amount,@Param("accountNumber") int accountNumber)
    {
        return new ResponseEntity<>(customerService.withdrawl(amount,accountNumber),HttpStatus.OK);
    }
}
