package com.project.bymanagement.service;

import com.project.bymanagement.model.dto.ResponseModelDTO;
import com.project.bymanagement.model.entity.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    List<Account> getByRole(String name);
    Account getById(int id);
    ResponseEntity<?> createAccount(Account account);
    ResponseEntity<?> updateAccount(Account account);
    void deleteAccount(int id);
}
