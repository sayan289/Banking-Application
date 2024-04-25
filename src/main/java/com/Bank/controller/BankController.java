package com.Bank.controller;

import com.Bank.payload.BankDto;
import com.Bank.entity.Branch;
import com.Bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Bank")
@EnableMethodSecurity(prePostEnabled = true)
public class BankController {
    @Autowired
    private BankService bankService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?>addbank(@RequestBody BankDto bankdto)
    {

         return new ResponseEntity<>(bankService.createBank(bankdto), HttpStatus.OK);
    }
    @GetMapping("/fetch")
    public ResponseEntity<?> getallbank()
    {
        return new ResponseEntity<>(bankService.getallbank(), HttpStatus.OK);
    }
    @GetMapping("/fetch/{bankId}")
    public ResponseEntity<?> getSingleBank(@PathVariable int bankId)
    {
        return new ResponseEntity<>(bankService.getSingleBank(bankId),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("addbranch/{bankId}")
    public ResponseEntity<?> addBranch(@RequestBody Branch branch,@PathVariable int bankId)
    {
        return new ResponseEntity<>(bankService.addBranch(bankId,branch),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{bankId}/{branchCode}")
    public ResponseEntity<?> deletebranch(@PathVariable int bankId,@PathVariable int branchCode)
    {
        return new ResponseEntity<>(bankService.deleteBranch(bankId,branchCode),HttpStatus.OK);
    }
}
