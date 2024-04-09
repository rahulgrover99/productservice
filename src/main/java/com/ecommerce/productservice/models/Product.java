package com.ecommerce.productservice.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
    private String seller;
}
