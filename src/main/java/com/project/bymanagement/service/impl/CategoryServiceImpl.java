package com.project.bymanagement.service.impl;

import com.project.bymanagement.model.dto.ResponseModelDTO;
import com.project.bymanagement.model.entity.CategoryService;
import com.project.bymanagement.repository.CategoryServiceRepository;
import com.project.bymanagement.service.CategoryServiceService;
import com.project.bymanagement.util.SourceMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryServiceService {
    @Autowired
    private CategoryServiceRepository categoryServiceRepository;

    @Autowired
    private SourceMessageUtils sourceMessageUtils;

    @Override
    public List<CategoryService> getAllInStorage() {
        return categoryServiceRepository.findAll();
    }

    @Override
    public ResponseEntity<?> updateStorage(Integer serviceId, CategoryService categoryService) {
        CategoryService serviceCurrent = categoryServiceRepository.getOne(serviceId);
        if (serviceCurrent != null) {
            ResponseModelDTO<?> responseModelDTO;
            serviceCurrent.setInforUpdateStorage(serviceCurrent);
            categoryServiceRepository.save(serviceCurrent);
            responseModelDTO = new ResponseModelDTO(HttpStatus.OK, "Success", null);
            return ResponseEntity.ok(responseModelDTO);
        } else {
            return ResponseEntity.badRequest().body("NOT_FOUND");
        }
    }
}
