package com.ecommerce.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    private String name;
    private String email;
}
