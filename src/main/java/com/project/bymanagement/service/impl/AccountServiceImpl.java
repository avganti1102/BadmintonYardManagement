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
import org.springframework.stereotype.Service;

import java.util.List;

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
            ResponseModelDTO<?> responseModelDTO = new ResponseModelDTO(HttpStatus.BAD_REQUEST, sourceMessageUtils.getMessage("MSG.CATEGORY.TITLE.EXIST"), null);
            return ResponseEntity.badRequest().body(responseModelDTO);
        }

        ResponseModelDTO<AccountDTO> responseModelDTO = new ResponseModelDTO(HttpStatus.OK, "CREATE SUCCESS", accountRepository.save(account));
        return ResponseEntity.ok(responseModelDTO);
    }

    @Override
    public ResponseEntity updateAccount(Account account) {
        Account accountCurrent = getById(account.getAccountId());
        accountCurrent.setInforUpdateAccount(account);
        ResponseModelDTO<AccountDTO> responseModelDTO = new ResponseModelDTO(HttpStatus.OK, "UPDATE SUCCESS", accountRepository.save(accountCurrent));
        return ResponseEntity.ok(responseModelDTO);
    }

    @Override
    public void deleteAccount(int id) {
        Account delAccount = accountRepository.getOne(id);
        accountRepository.delete(delAccount);
    }
}
