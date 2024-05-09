package com.example.eight0eightdot.entity.Product;

import com.example.eight0eightdot.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Variant extends BaseEntity {
    private int product_id;
    private int property_id;
    private String SKU;
    private double cost;
    private double price;
    private int status;
}
