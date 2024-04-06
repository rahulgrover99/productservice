package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

//    https://fakestoreapi.com/products/15

    @GetMapping("/{identity}/{temp}")
    public String getProductById(@PathVariable("identity") Long id, @PathVariable("temp") String x) {
        return "Here's your product "  + id + x;
    }

//    @RequestBody Product product -> Converts the received json to a Product java object
    @PostMapping("")
    public String createProduct(@RequestBody Product product) {
        System.out.println(product.getCategory());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        return "Product created.";
    }

}
