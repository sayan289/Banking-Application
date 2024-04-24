package com.Bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
    private int branchCode;
    private String branchCity;
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Account.class)
    @JoinColumn(name="branchCode",referencedColumnName = "branchCode")
    private List<Account> accountList;
}
