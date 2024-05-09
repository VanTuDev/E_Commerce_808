package com.example.eight0eightdot.service;


import com.example.eight0eightdot.dto.ProductResponse;
import com.example.eight0eightdot.entity.Product.Category;
import com.example.eight0eightdot.entity.Product.Product;
import com.example.eight0eightdot.mapper.ProductMapper;
import com.example.eight0eightdot.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;



    public Optional<List<Product>> findProductsByCategory(Category category){
        return Optional.ofNullable(productRepository.findProductsByCategory(category));
    }

    public Optional<Product> findProduct(Integer id){
        return productRepository.findById(id);
    }

    public List<ProductResponse> findAll(){
        return productMapper.fromProductList(productRepository.findAll());
    }

}
