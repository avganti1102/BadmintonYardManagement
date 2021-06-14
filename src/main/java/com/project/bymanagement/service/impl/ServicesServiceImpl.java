package com.project.bymanagement.service.impl;

import com.project.bymanagement.model.entity.Services;
import com.project.bymanagement.repository.AccountRepository;
import com.project.bymanagement.repository.BookYardRepository;
import com.project.bymanagement.repository.CategoryServiceRepository;
import com.project.bymanagement.repository.ServicesRepository;
import com.project.bymanagement.service.ServicesService;
import com.project.bymanagement.util.SourceMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private SourceMessageUtils sourceMessageUtils;

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CategoryServiceRepository categoryServiceRepository;

    @Override
    public List<Services> buyingHistory(Integer accountId) {
        return servicesRepository.findAllByAccountId(accountId);
    }

//    @Override
//    public ResponseEntity<?> buying(Services services) {
//        return null;
//    }

//    @Override
//    public ResponseEntity<?> buying(Integer categoryI, Integer accountId) {
//        Services buying = new Services();
//        buying.setAccountId(accountRepository.getOne(accountId));
//        buying.setQuantity(services.getQuantity());
//        buying.setCategoryServiceId(services.getCategoryServiceId());
//        buying.setTotalMoney(String.valueOf(buying.getQuantity() * Integer.parseInt(services.getCategoryServiceId().getPrice())));
//
//        ResponseModelDTO<SubCategory> responseModelDTO = new ResponseModelDTO(HttpStatus.OK, ApiErrorCode.SUCCESS.getMessage(), subCategoryRepository.save(subCategory));
//        return ResponseEntity.ok(responseModelDTO);
//    }
}
