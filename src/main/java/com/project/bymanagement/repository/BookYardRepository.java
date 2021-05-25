package com.project.bymanagement.repository;

import com.project.bymanagement.model.entity.BookYard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookYardRepository extends JpaRepository<BookYard, Integer> {
    List<BookYard> findAllByAccountId(Integer accountId);
}
