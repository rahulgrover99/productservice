package com.ecommerce.productservice.service;


import com.ecommerce.productservice.models.GenericProduct;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.repository.GenericProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GenericProductService {

    private final GenericProductRepository genericProductRepository;

    public GenericProductService(GenericProductRepository genericProductRepository) {
        this.genericProductRepository = genericProductRepository;
    }

    private static final String[] PRODUCT_NAMES = {
            "TV", "Headphones", "Smartphone", "Laptop", "Tablet",
            "Camera", "Speaker", "Drone", "Gaming Console", "Smartwatch",
            "Fitness Tracker", "External Hard Drive", "Monitor", "Router",
            "Printer", "Keyboard", "Mouse", "Earbuds", "Projector", "Desk"
    };


    public boolean generateProductData() {
        List<GenericProduct> productList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            String productName = PRODUCT_NAMES[i];
            int price = random.nextInt(10000);

            GenericProduct genericProduct = new GenericProduct(productName, price);
            productList.add(genericProduct);
        }

        genericProductRepository.saveAll(productList);

        return true;
    }


    public List<GenericProduct> searchProducts(String query) {

        return genericProductRepository.findAll();

    }

    public Page<GenericProduct> searchProductsByPagination(String query, int pageNumber, int pageSize, String sorting) {

        return switch (sorting) {
            case "id-asc" -> genericProductRepository.findAll(
                    PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id")
            );
            case "name-desc" -> genericProductRepository.findAll(
                    PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "name")
            );
            default -> genericProductRepository.findAll(
                    PageRequest.of(pageNumber, pageSize)
            );
        };

    }
}
