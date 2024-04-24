package com.Bank.controller;

import com.Bank.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branch")
public class BranchControlller {
    @Autowired
    private BranchService branchService;
    @GetMapping("/fetch/{bankId}")
    public ResponseEntity<?> getAllBranch(@PathVariable int bankId)
    {
        return branchService.getAllBranch(bankId);
    }
    @GetMapping("/fetch/single/{bankId}/{branchCode}")
    public ResponseEntity<?> getSingleBranch(@PathVariable int bankId,@PathVariable int branchCode)
    {
        return branchService.getSingleBranch(bankId,branchCode);
    }
}
