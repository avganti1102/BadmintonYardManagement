package com.project.bymanagement.service;

import com.project.bymanagement.model.dto.AccountRegistrationDto;
import com.project.bymanagement.model.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService extends UserDetailsService {
    Account findByAccountName(String name);
    Account findByPhone(String phone);
    List<Account> getAllAccount();
    List<Account> getByRole(String name);
    Account getById(int id);
    ResponseEntity<?> createAccount(AccountRegistrationDto registrationDto);
    ResponseEntity<?> updateAccount(Account account);
    ResponseEntity<?> updateRoleAccount(Integer accountId, String role);
    ResponseEntity<?> deleteAccount(Integer id);
    ResponseEntity<?> deleteAccountByAdmin(Integer id);
}
