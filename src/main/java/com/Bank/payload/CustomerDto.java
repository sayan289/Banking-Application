package com.Bank.payload;

import com.Bank.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerPassword;
    private Account account;
}
