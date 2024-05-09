package com.example.eight0eightdot.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductRequest {
    private Integer id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
