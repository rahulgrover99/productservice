package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.models.GenericProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericProductRepository extends JpaRepository<GenericProduct, Long> {


    Page<GenericProduct> findAll(Pageable pageable);

    Page<GenericProduct> findAllByName(String name, Pageable pageable);

}
