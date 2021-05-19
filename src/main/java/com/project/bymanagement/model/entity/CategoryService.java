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
}
