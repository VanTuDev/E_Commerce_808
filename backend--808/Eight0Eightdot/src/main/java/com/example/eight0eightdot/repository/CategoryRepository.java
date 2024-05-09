package com.example.eight0eightdot.repository;

import com.example.eight0eightdot.entity.Product.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>, JpaSpecificationExecutor<Category> {
    Page<Category> findAll(Pageable pageable);
    Page<Category> findBySlug(String slug,Pageable pageable);

}
