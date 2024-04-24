package com.Bank.repository;

import com.Bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepo extends JpaRepository<Bank,Integer> {
//    public Optional<?> deleteBranchByBankCode(int branchCode);
}
