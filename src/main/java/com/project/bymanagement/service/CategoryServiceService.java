package com.project.bymanagement.service;

import com.project.bymanagement.model.entity.Account;
import com.project.bymanagement.model.entity.CategoryService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryServiceService {
    List<CategoryService> getAllInStorage();
    ResponseEntity<?> updateStorage(Integer serviceId, CategoryService categoryService);
}
