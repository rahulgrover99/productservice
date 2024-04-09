package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.exceptions.NotFoundException;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public GetProductDto getProductById(Long id) throws NotFoundException {


        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);

        System.out.println(product);

        if (product == null) {
            throw new NotFoundException();
        }

        // Call the DB
        // Call the Fake Store API.
        // https://fakestoreapi.com/products/15
        return convertToDto(product);

    }

    private static GetProductDto convertToDto(Product product) {
        GetProductDto obj =  new GetProductDto();
        obj.setName(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImageUrl(product.getImage());
        return obj;
    }


    public List<GetProductDto> getAllProducts() {
        // 1. Make a call to 3p api.
        // 2. Deserialize into Java object -> Array of products
        // 3. Convert the array into array/list of dto objects.
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/";
        Product[] products = restTemplate.getForObject(url, Product[].class);

        List<GetProductDto> returnedProducts = new ArrayList<>();

        for (Product product: products) {
            returnedProducts.add(convertToDto(product));
        }
        return returnedProducts;
    }
}
