package com.Bank.payload;

import com.Bank.entity.Branch;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BankDto {
    private int bankId;
    private String bankName;
    private String bankCode;
    private List<BranchDto> branch;
}
