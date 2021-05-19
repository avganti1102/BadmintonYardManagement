package com.project.bymanagement.model.dto;

public class AccountDTO {
    private Integer accountId;
    private String accountName;
    private String fullName;
    private String phone;
    private String address;
    private String role;

    public AccountDTO() {
    }

    public AccountDTO(Integer accountId, String accountName, String fullName, String phone, String address, String role) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
