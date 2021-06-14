package com.project.bymanagement.api;

import com.project.bymanagement.model.dto.AccountRegistrationDto;
import com.project.bymanagement.model.entity.Account;
import com.project.bymanagement.service.AccountService;
import com.project.bymanagement.service.BookYardService;
import com.project.bymanagement.service.CategoryServiceService;
import com.project.bymanagement.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserApi {
    @Autowired
    private AccountService accountService;

    @Autowired
    private BookYardService bookYardService;

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private CategoryServiceService categoryServiceService;


    @PostMapping(value = "/create")
    public ResponseEntity<?> createAccount(@RequestBody AccountRegistrationDto registrationDto){
        return new ResponseEntity<>(accountService.createAccount(registrationDto), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public  ResponseEntity<?> updateAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }

    @GetMapping(value = "/book-history/{id}")
    public ResponseEntity<?> bookingHistory(@PathVariable(name = "id")Integer accountId){
        return new ResponseEntity<>(bookYardService.getAllBookingHistory(accountId), HttpStatus.OK);
    }

    @GetMapping(value = "/buying-history/{id}")
    public ResponseEntity<?> buyingHistory(@PathVariable(name = "id")Integer accountId){
        return new ResponseEntity<>(servicesService.buyingHistory(accountId), HttpStatus.OK);
    }

//    @PostMapping(value = "/buying")
//    public ResponseEntity<?> buying(@RequestBody Account account){
//        return new ResponseEntity<>(servicesService.create(account), HttpStatus.OK);
//    }
}
