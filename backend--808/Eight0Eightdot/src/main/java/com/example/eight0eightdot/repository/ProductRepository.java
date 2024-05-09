package com.example.eight0eightdot.repository;

import com.example.eight0eightdot.entity.Product.Category;
import com.example.eight0eightdot.entity.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {

     List<Product> findProductsByCategory(Category category);

}
