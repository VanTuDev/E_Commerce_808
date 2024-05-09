package com.example.eight0eightdot.controller;

import com.example.eight0eightdot.dto.UploadedImageResponse;
import com.example.eight0eightdot.service.GeneralService.Image.ImageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
@Slf4j
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload-single")
    public UploadedImageResponse uploadSingleImage(@RequestParam("image") MultipartFile image) throws IOException {
        return imageService.store(image);
    }

    @GetMapping("/{imageName:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String imageName, HttpServletRequest request) {
        Resource resource = imageService.load(imageName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.info("Could not determine file type.");
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @DeleteMapping("/{imageName:.+}")
    public ResponseEntity<Void> deleteImage(@PathVariable String imageName) {
        imageService.delete(imageName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
