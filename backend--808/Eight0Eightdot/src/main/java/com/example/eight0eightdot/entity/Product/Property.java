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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
public class Property extends BaseEntity {

    private String cpu1;
    private String ram;
    private String gpu;
    private String screenSize;
    private String screen_resolution;
    private String screen_technology;
    private String storage_capacity;
    private String port;
    private String battery_life;
    private String weight;
    private String dimension;
    private String operating_system;
    private String color;

}
