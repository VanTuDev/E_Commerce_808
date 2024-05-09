package com.example.eight0eightdot.dto;

import lombok.Value;

@Value
public class UploadedImageResponse {
    String name;
    String path;
    String contentType;
    long size;
}