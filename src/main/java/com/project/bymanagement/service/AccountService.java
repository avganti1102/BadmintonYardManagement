package com.project.bymanagement.service;

import com.project.bymanagement.model.dto.ResponseModelDTO;
import com.project.bymanagement.model.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService extends UserDetailsService {
    List<Account> getAllAccount();
    List<Account> getByRole(String name);
    Account getById(int id);
    ResponseEntity<?> createAccount(Account account);
    ResponseEntity<?> updateAccount(Account account);
    ResponseEntity<?> updateRoleAccount(Integer accountId, String role);
    ResponseEntity<?> deleteAccount(Integer id);
}
