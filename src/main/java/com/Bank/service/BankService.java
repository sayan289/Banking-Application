package com.Bank.service;

import com.Bank.payload.BankDto;
import com.Bank.entity.Bank;
import com.Bank.entity.Branch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {
    public Bank createBank(BankDto bank);
    public List<BankDto> getallbank();
    public BankDto getSingleBank(int bankId);
    public Bank addBranch(int bankId, Branch branch);
    public String deleteBranch(int bankId, int branchCode);
}
