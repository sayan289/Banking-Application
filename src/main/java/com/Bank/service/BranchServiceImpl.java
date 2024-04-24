package com.Bank.service;

import com.Bank.entity.Branch;
import com.Bank.exception.CustomException;
import com.Bank.repository.BankRepo;
import com.Bank.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BranchServiceImpl implements BranchService{
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private BankRepo bankRepo;
    public ResponseEntity<?> getSingleBranch(int bankId, int branchCode)
    {
        bankRepo.findById(bankId).orElseThrow(()->new CustomException("Bank Id not found"));
        Optional<Branch> byId = branchRepo.findById(branchCode);
        if(byId.isEmpty())
        {
            return new ResponseEntity<>("Branch Id does not present", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(byId.get(),HttpStatus.OK);
        }
    }
    public ResponseEntity<?> getAllBranch(int bankId)
    {
        bankRepo.findById(bankId).orElseThrow(()->new CustomException("Bank Id not found"));
        return new ResponseEntity<>(branchRepo.findAll(),HttpStatus.OK);
    }
}
