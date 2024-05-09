package com.example.eight0eightdot.mapper;

import com.example.eight0eightdot.dto.ProductResponse;
import com.example.eight0eightdot.entity.Product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


// Notice : This mapper with Product -> ProductDTO
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ProductMapper {

    Product toProduct(ProductResponse productResponse);
    List<ProductResponse> fromProductList(List<Product> product);


}
