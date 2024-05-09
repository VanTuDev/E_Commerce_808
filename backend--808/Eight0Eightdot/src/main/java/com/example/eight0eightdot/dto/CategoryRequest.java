package com.example.eight0eightdot.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CategoryRequest {
    private int id;
    private String name;
    private String slug;
    private String thumbnail;
    private LocalDateTime createAt;
    protected LocalDateTime updateAt;
}
