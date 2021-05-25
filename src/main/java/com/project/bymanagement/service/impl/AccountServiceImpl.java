package com.project.bymanagement.service.impl;

import com.project.bymanagement.model.dto.AccountDTO;
import com.project.bymanagement.model.dto.ResponseModelDTO;
import com.project.bymanagement.model.entity.Account;
import com.project.bymanagement.repository.AccountRepository;
import com.project.bymanagement.service.AccountService;
import com.project.bymanagement.util.SourceMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SourceMessageUtils sourceMessageUtils;

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getByRole(String role) {
        return accountRepository.findByRole(role);
    }

    @Override
    public Account getById(int id) {
        return accountRepository.getOne(id);
    }

    @Override
    public ResponseEntity createAccount(Account account) {
        if (accountRepository.countAllByAccountName(account.getAccountName()) > 0) {
            ResponseModelDTO<?> responseModelDTO = new ResponseModelDTO(HttpStatus.BAD_REQUEST, sourceMessageUtils.getMessage("Ten da ton tai"), null);
            return ResponseEntity.badRequest().body(responseModelDTO);
        }

        ResponseModelDTO<AccountDTO> responseModelDTO = new ResponseModelDTO(HttpStatus.OK, "CREATE SUCCESS", accountRepository.save(account));
        return ResponseEntity.ok(responseModelDTO);
    }

    @Override
    public ResponseEntity<?> updateRoleAccount(Integer accountId,String role) {
        Account accountCurrent = accountRepository.getOne(accountId);
        if (accountCurrent != null) {
            ResponseModelDTO<?> responseModelDTO;
            accountCurrent.setRole(role);
            accountRepository.save(accountCurrent);
            responseModelDTO = new ResponseModelDTO(HttpStatus.OK, "Success", null);
            return ResponseEntity.ok(responseModelDTO);
        } else {
            return ResponseEntity.badRequest().body("NOT_FOUND");
        }
    }

    @Override
    public ResponseEntity updateAccount(Account account) {
        Account accountCurrent = getById(account.getId());
        if (accountCurrent != null) {
            ResponseModelDTO<?> responseModelDTO;
            accountCurrent.setInforUpdateAccount(account);
            accountRepository.save(accountCurrent);
            responseModelDTO = new ResponseModelDTO(HttpStatus.OK, "Success", null);
            return ResponseEntity.ok(responseModelDTO);
        } else {
            return ResponseEntity.badRequest().body("NOT_FOUND");
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteAccount(Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            ResponseModelDTO<?> responseModelDTO;
            accountRepository.delete(account.get());
            responseModelDTO = new ResponseModelDTO(HttpStatus.OK, "Success", null);
            return ResponseEntity.ok(responseModelDTO);
        } else {
            return ResponseEntity.badRequest().body("NOT_FOUND");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = accountRepository.findByAccountName(accountName);

        if (account == null) {
            throw new UsernameNotFoundException(accountName);
        }

        return new org.springframework.security.core.userdetails.User(
                account.getAccountName(),
                account.getPassWord(),
                AuthorityUtils.createAuthorityList(account.getRole()));
    }
}
