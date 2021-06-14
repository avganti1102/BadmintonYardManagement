package com.project.bymanagement.service;

import com.project.bymanagement.model.entity.BookYard;

import java.util.List;

public interface BookYardService {
    List<BookYard> getAllBookingHistory(Integer accountId);
}
