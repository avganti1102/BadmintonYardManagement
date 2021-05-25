package com.project.bymanagement.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`accountName`", length = 15)
    private String accountName;

    @Column(name = "`password`", length = 15)
    private String passWord;

    @Column(name = "`firstName`", length = 50)
    private String firstName;

    @Column(name = "`lastName`", length = 50)
    private String lastName;

    @Formula("concat(firstName, ' ', lastName)")
    private String fullName;

    @Column(name = "role")
    private String role;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "address", length = 256)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountId")
    @JsonIgnore
    private List<Services> services = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountId")
    @JsonIgnore
    private List<BookYard> bookYards = new ArrayList<>();



    public Account() {
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BookYard> getBookYards() {
        return bookYards;
    }

    public void setBookYards(List<BookYard> bookYards) {
        this.bookYards = bookYards;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public void setInforUpdateAccount(Account accountUpdate) {
        this.accountName = accountUpdate.getAccountName();
        this.firstName = accountUpdate.getFirstName();
        this.lastName = accountUpdate.getLastName();
        this.phone = accountUpdate.getPhone();
        this.address = accountUpdate.getAddress();
    }
}
