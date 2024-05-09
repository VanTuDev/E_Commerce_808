package com.example.eight0eightdot.controller;

import com.example.eight0eightdot.dto.ProductResponse;
import com.example.eight0eightdot.entity.Product.Product;
import com.example.eight0eightdot.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/find-all-product-by-category/{categoryId}")
//    public ResponseEntity<Optional<List<Product>>> findAllProductByCategory(@PathVariable String categoryId){
//        Category category = new Category();
//        category.setId(Integer.parseInt(categoryId));
//        return ResponseEntity.ok(productService.findProductsByCategory(category));
//    }
    @GetMapping("/find-by-product/{productId}")
    public ResponseEntity<Optional<Product>> findByProduct(@PathVariable String productId){
        return ResponseEntity.ok(productService.findProduct(Integer.parseInt(productId)));
    }
    @GetMapping("/find-all")
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
}
