package com.Bank.payload;

import com.Bank.entity.Branch;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {
    private int accountNumber;
    private long balance;
    private String accountType;
}
