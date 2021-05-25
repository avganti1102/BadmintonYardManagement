package com.project.bymanagement.api;

import com.project.bymanagement.model.entity.Account;
import com.project.bymanagement.service.AccountService;
import com.project.bymanagement.service.BookYardService;
import com.project.bymanagement.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/admin")
public class AccountApi {
    @Autowired
    private AccountService accountService;

    @Autowired
    private BookYardService bookYardService;

    @Autowired
    private ServicesService servicesService;


    @PostMapping(value = "")
    public ResponseEntity<?> createAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public  ResponseEntity<?> updateAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }

    @GetMapping(value = "/book-history/{id}")
    public ResponseEntity<?> bookHistory(@PathVariable(name = "id")Integer accountId){
        return new ResponseEntity<>(bookYardService.getAllBookHistory(accountId), HttpStatus.OK);
    }

    @GetMapping(value = "/buying-history/{id}")
    public ResponseEntity<?> buyingHistory(@PathVariable(name = "id")Integer accountId){
        return new ResponseEntity<>(servicesService.buyingHistory(accountId), HttpStatus.OK);
    }
}
