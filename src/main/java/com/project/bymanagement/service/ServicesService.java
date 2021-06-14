package com.project.bymanagement.service;

import com.project.bymanagement.model.entity.Services;

import java.util.List;

public interface ServicesService {
    List<Services> buyingHistory(Integer accountId);
//    ResponseEntity<?> buying(Services services);
}
