package com.project.bymanagement.controller;

import com.project.bymanagement.model.dto.AccountRegistrationDto;
import com.project.bymanagement.model.entity.Account;
import com.project.bymanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class AccountRegistrationController {

    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public AccountRegistrationDto accountRegistrationDto() {
        return new AccountRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("account") @Validated AccountRegistrationDto accountDto,
                                      BindingResult result){

        Account existing = accountService.findByAccountName(accountDto.getAccountName());
        Account phoneExists = accountService.findByPhone(accountDto.getPhone());
        if (existing != null){
            result.rejectValue("Account", null, "There is already an account registered with that name");
        }
        if (phoneExists != null){
            result.rejectValue("Phone", null, "There is already a phone registered with another account");
        }

        if (result.hasErrors()){
            return "registration";
        }

        accountService.createAccount(accountDto);
        return "redirect:/registration?success";
    }

}
