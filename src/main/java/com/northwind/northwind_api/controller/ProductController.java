package com.northwind.northwind_api.controller;

import com.northwind.northwind_api.model.Product;
import com.northwind.northwind_api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.deleteProduct(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable Long categoryId) {
        List<Product> products = productService.getProductByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search/{productName}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String productName) {
        List<Product> products = productService.getProductByName(productName);
        return ResponseEntity.ok(products);
    }

}
