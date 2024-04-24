package com.Bank.service;
import com.Bank.payload.BankDto;
import com.Bank.entity.Bank;
import com.Bank.entity.Branch;
import com.Bank.exception.CustomException;
import com.Bank.repository.BankRepo;
import com.Bank.repository.BranchRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BankServiceImpl implements BankService{
    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BranchRepo branchRepo;
    public Bank createBank(BankDto bank)
    {
        return bankRepo.save(modelMapper.map(bank, Bank.class));
    }
    public List<BankDto> getallbank()
    {
        List<Bank> allbank=bankRepo.findAll();
        List<BankDto> record=new ArrayList<>();
        allbank.forEach(all->{
            record.add(modelMapper.map(all,BankDto.class));
        });
        return record;
    }
    public BankDto getSingleBank(int bankId)
    {
        Bank bank= bankRepo.findById(bankId).orElseThrow(()->new CustomException("Id Not present"));
        return modelMapper.map(bank,BankDto.class);
    }
    public Bank addBranch(int bankId, Branch branch)
    {
       Bank bank= bankRepo.findById(bankId).orElseThrow(()->new CustomException("Id Not present"));
       List<Branch> branches=bank.getBranch();
       branches.add(branch);
       bank.setBranch(branches);
       return bankRepo.save(bank);
    }
    public String deleteBranch(int bankId, int branchCode)
    {
        Bank bank = bankRepo.findById(bankId).orElseThrow(() -> new CustomException("Bank id not found"));
        Optional<Branch> branch = branchRepo.findById(branchCode);
        if (branch.isEmpty()) {
            throw new CustomException("Branch Code not found");
        } else {
            branchRepo.deleteById(branchCode);
            return "Branch deleted successfully";
        }
    }
}
