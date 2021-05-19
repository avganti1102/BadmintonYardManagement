package com.project.bymanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "yard")
public class Yard implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "yardName")
    private String yardName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "yardId")
    @JsonIgnore
    private List<BookYard> bookYards = new ArrayList<>();

    public Yard() {
    }

    public List<BookYard> getBookYards() {
        return bookYards;
    }

    public void setBookYards(List<BookYard> bookYards) {
        this.bookYards = bookYards;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYardName() {
        return yardName;
    }

    public void setYardName(String yardName) {
        this.yardName = yardName;
    }
}
