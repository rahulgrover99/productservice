package com.ecommerce.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Instructor extends User{
    private Double salary;
    private String skill;
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.REMOVE)
    private List<Batch> batch;

}
