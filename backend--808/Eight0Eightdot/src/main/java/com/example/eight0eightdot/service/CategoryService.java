package com.example.eight0eightdot.service;

import com.example.eight0eightdot.dto.CategoryRequest;
import com.example.eight0eightdot.entity.Product.Category;
import com.example.eight0eightdot.mapper.CategoryMapper;
import com.example.eight0eightdot.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryRequest> categories(){
        return categoryMapper.fromCategories(categoryRepository.findAll());
    }
    public Optional<Category> findById(Integer id){
        return categoryRepository.findById(id);
    }
    public Category save(Category category){
        return categoryRepository.save(category);
    }


}
