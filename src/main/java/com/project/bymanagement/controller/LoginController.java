package com.project.bymanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/login")
public class LoginController {

    @GetMapping()
    public ResponseEntity<?> login() {
        return new ResponseEntity<>("Login Successfully!", HttpStatus.OK);
    }
}
