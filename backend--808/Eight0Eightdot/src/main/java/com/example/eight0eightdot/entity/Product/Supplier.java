package com.example.eight0eightdot.entity.Product;

import com.example.eight0eightdot.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "supplier")
public class Supplier  extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "thumbnail")
    private String thumbnail;
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();
}
