package com.example.eight0eightdot.entity.Product;

import com.example.eight0eightdot.dto.CategoryRequest;
import com.example.eight0eightdot.entity.BaseEntity;
import com.example.eight0eightdot.entity.Product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@Entity
@Table(name = "category")
public class Category extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "slug")
    private String slug;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();


}
