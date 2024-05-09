package com.example.eight0eightdot.service.GeneralService.Image;

import com.example.eight0eightdot.dto.UploadedImageResponse;
import com.example.eight0eightdot.entity.General.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    UploadedImageResponse store(MultipartFile image) throws IOException;

    Resource load(String imageName);

    void delete(String imageName);

}
