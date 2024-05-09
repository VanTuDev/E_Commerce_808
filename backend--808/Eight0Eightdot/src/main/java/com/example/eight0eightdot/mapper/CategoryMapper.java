package com.example.eight0eightdot.mapper;

import com.example.eight0eightdot.dto.CategoryRequest;
import com.example.eight0eightdot.entity.Product.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CategoryMapper {
    CategoryRequest toCategory(CategoryRequest categoryRequest);
    List<CategoryRequest> fromCategories(List<Category> categories);
}
