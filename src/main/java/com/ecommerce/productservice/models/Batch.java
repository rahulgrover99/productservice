package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Getter
@Setter
public class Batch {
    @Id
    private Long id;
    private String name;
    private Integer strength;

    @ManyToOne()
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}
