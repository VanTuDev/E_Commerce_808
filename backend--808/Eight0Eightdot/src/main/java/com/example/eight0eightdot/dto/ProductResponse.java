package com.example.eight0eightdot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ProductResponse {

    private Integer id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
