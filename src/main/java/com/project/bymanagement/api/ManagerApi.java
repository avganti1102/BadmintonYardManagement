package com.project.bymanagement.api;

import com.project.bymanagement.model.entity.CategoryService;
import com.project.bymanagement.service.AccountService;
import com.project.bymanagement.service.CategoryServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/manager")
public class ManagerApi {
    @Autowired
    private CategoryServiceService categoryServiceService;

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") Integer accountId) {
        return new ResponseEntity<>(accountService.deleteAccount(accountId), HttpStatus.OK);
    }

    @GetMapping(value = "/storage")
    public ResponseEntity<?> getAllInStorage() {
        return new ResponseEntity<>(categoryServiceService.getAllInStorage(), HttpStatus.OK);
    }
}
