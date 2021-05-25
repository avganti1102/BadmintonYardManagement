package com.project.bymanagement.repository;

import com.project.bymanagement.model.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Services, Integer> {
    List<Services> findAllByAccountId(Integer accountId);
}
