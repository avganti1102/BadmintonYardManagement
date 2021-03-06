package com.project.bymanagement.api;

import com.project.bymanagement.model.entity.CategoryService;
import com.project.bymanagement.service.AccountService;
import com.project.bymanagement.service.CategoryServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminApi {
    @Autowired
    private AccountService accountService;

    @Autowired
    private CategoryServiceService categoryServiceService;

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") Integer accountId) {
        return new ResponseEntity<>(accountService.deleteAccountByAdmin(accountId), HttpStatus.OK);
    }

    @PostMapping(value = "/update-role/{id}")
    public  ResponseEntity<?> updateAccount(@PathVariable(name = "id") Integer accountId, @RequestBody String role){
        return new ResponseEntity<>(accountService.updateRoleAccount(accountId, role), HttpStatus.OK);
    }

    @PostMapping(value = "/update-storage/{id}")
    public ResponseEntity<?> updateStorage(@PathVariable(name = "id") Integer serviceId, @RequestBody CategoryService categoryService){
        return new ResponseEntity<>(categoryServiceService.updateStorage(serviceId, categoryService), HttpStatus.OK);
    }
}
