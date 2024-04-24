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
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;
    private String bankName;
    private String bankCode;
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Branch.class)
    @JoinColumn(name="bankId",referencedColumnName = "bankId")
    private List<Branch> branch;
}
