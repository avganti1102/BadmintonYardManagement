package com.project.bymanagement.repository;

import com.project.bymanagement.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByRole(String role);

    int countAllByAccountName(String accountName);

}
