package com.project.bymanagement.service.impl;

import com.project.bymanagement.model.entity.BookYard;
import com.project.bymanagement.repository.BookYardRepository;
import com.project.bymanagement.service.BookYardService;
import com.project.bymanagement.util.SourceMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookYardServiceImpl implements BookYardService {
    @Autowired
    private SourceMessageUtils sourceMessageUtils;

    @Autowired
    private BookYardRepository bookYardRepository;

    @Override
    public List<BookYard> getAllBookHistory(Integer accountId) {
        return bookYardRepository.findAllByAccountId(accountId);
    }
}
