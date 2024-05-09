package com.example.eight0eightdot.entity.Product;

import com.example.eight0eightdot.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "short_description", nullable = false)
    private String short_description;
    @Column(name = "long_description", nullable = false)
    private String long_description;
    @Column(name = "code_name", nullable = false)
    private String code_name;
    @Column(name = "slug", nullable = false)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    private String thumbnail;
}
