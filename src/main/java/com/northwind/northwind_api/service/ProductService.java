package com.northwind.northwind_api.service;

import com.northwind.northwind_api.model.Product;
import com.northwind.northwind_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

//    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
//        return productService.findById(id).map(existing -> {
//            existing.setproductName(updatedProduct.getName());
//            return productService.save(existing);
//        });
//    }
//
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

