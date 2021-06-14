package com.project.bymanagement.model.dto;


import com.sun.istack.NotNull;

public class AccountRegistrationDto {

    @NotNull
    private String accountName;
    @NotNull
    private String phone;
    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
