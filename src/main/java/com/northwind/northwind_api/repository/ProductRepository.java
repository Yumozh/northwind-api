package com.northwind.northwind_api.repository;

import com.northwind.northwind_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> getProductById(Long id);
    List<Product> findByProductNameContainingIgnoreCase(String name);
//    Product createProduct(Product product);
}

