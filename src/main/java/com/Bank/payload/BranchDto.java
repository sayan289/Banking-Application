package com.Bank.payload;

import com.Bank.entity.Account;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BranchDto {
    private int branchCode;
    private String branchCity;
    private List<Account> accountList;
}
