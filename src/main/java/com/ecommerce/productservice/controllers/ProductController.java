package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public @ResponseBody GetProductDto getProductById(
            @PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

//    @RequestBody Product product -> Converts the received json to a Product java object
    @PostMapping("")
    public String createProduct(@RequestBody Product product) {
        System.out.println(product.getCategory());
        System.out.println(product.getTitle());
        System.out.println(product.getPrice());
        return "Product created.";
    }

}
