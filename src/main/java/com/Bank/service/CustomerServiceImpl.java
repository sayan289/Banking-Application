package com.Bank.service;

import com.Bank.entity.Account;
import com.Bank.entity.Branch;
import com.Bank.entity.Customer;
import com.Bank.entity.Role;
import com.Bank.exception.CustomException;
import com.Bank.payload.CustomerDto;
import com.Bank.repository.AccountRepo;
import com.Bank.repository.BranchRepo;
import com.Bank.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private AccountRepo accountRepo;

    public CustomerDto addcustomer(CustomerDto customerDto,int branchCode)
    {
        Account account=new Account();
        Random random = new Random();
        account.setBalance(0);
        account.setAccountType("Savings");
        account.setAccountNumber(Math.abs(random.nextInt()));
        Branch branch = branchRepo.findById(branchCode).orElseThrow(() -> new CustomException("Branch not found"));
        List<Account> accountList = new ArrayList<>(branch.getAccountList());
        accountList.add(account);
        branch.setAccountList(accountList);
        branchRepo.save(branch);
        customerDto.setAccount(account);
        Customer customer =modelMapper.map(customerDto, Customer.class);
        Role role=new Role();
        role.setId(2);
        role.setName("NORMAL_USER");
        customer.setRoles(Collections.singletonList(role));
        customerRepo.save(customer);
        return customerDto;
    }
    public ResponseEntity<?> getCustomerbyCustomerId(int customerId)
    {
        Optional<Customer> byId = customerRepo.findById(customerId);
        if(byId.isEmpty())
        {
            return new ResponseEntity<>("No such customer id present", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(byId.get(),HttpStatus.OK);
        }
    }
    public ResponseEntity<?> getCustomerByAccountNumber(int accountNumber)
    {
        Optional<Customer> customer=customerRepo.getCustomerByAccountNumber(accountNumber);
        if(customer.isEmpty())
        {
            return new ResponseEntity<>("Bank Id not present",HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(customer.get(),HttpStatus.OK);
        }
    }
    public List<CustomerDto> getall()
    {
        List<Customer> customer = customerRepo.findAll();
        List<CustomerDto> customerdto=new ArrayList<>();
        customer.forEach(all->{
            customerdto.add(modelMapper.map(all,CustomerDto.class));
        });
        return customerdto;
    }
    public String deleteCustomer(int customerId)
    {
        Optional<Customer> byId = customerRepo.findById(customerId);
        if(byId.isEmpty())
        {
            throw  new CustomException("Customer id not found");
        }
        else {
            return "Customer deleted";
        }

    }
    public Account deposite(int amount, int accountNumber)
    {
        Account account = accountRepo.findById(accountNumber).orElseThrow(() -> new CustomException("No Account avaible"));
        account.setBalance(account.getBalance()+amount);
        return accountRepo.save(account);
    }
    public Account withdrawl(int amount, int accountNumber)
    {
        Account account = accountRepo.findById(accountNumber).orElseThrow(() -> new CustomException("No Account Avaible"));
        long balance=account.getBalance();
        if(balance<amount)
        {
            throw new CustomException("Low Balance");
        }
        else {
            account.setBalance(account.getBalance()-amount);
            return accountRepo.save(account);
        }
    }
}
