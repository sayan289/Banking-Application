package com.Bank.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BranchService {
    public ResponseEntity<?> getSingleBranch(int bankId, int branchCode);
    public ResponseEntity<?> getAllBranch(int bankId);
}
