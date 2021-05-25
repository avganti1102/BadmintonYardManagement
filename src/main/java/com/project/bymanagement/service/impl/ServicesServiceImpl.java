package com.project.bymanagement.service.impl;

import com.project.bymanagement.model.entity.Services;
import com.project.bymanagement.repository.BookYardRepository;
import com.project.bymanagement.repository.ServicesRepository;
import com.project.bymanagement.service.ServicesService;
import com.project.bymanagement.util.SourceMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private SourceMessageUtils sourceMessageUtils;

    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public List<Services> buyingHistory(Integer accountId) {
        return servicesRepository.findAllByAccountId(accountId);
    }
}
