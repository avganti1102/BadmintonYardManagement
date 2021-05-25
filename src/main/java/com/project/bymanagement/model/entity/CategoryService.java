package com.project.bymanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "category_service")
public class CategoryService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_service")
    private String categoryService;

    @Column(name = "price")
    private String price;

    @Column(name = "storage")
    private Integer storage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryServiceId")
    @JsonIgnore
    private List<Services> services = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(String categoryService) {
        this.categoryService = categoryService;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public void setInforUpdateStorage(CategoryService categoryServiceUpdate) {
        this.categoryService = categoryServiceUpdate.getCategoryService();
        this.price = categoryServiceUpdate.getPrice();
        this.storage = categoryServiceUpdate.getStorage();
    }
}
