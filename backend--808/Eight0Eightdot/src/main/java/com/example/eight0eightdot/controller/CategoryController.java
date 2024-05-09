package com.example.eight0eightdot.controller;

import com.example.eight0eightdot.dto.CategoryRequest;
import com.example.eight0eightdot.entity.Product.Category;
import com.example.eight0eightdot.repository.CategoryRepository;
import com.example.eight0eightdot.service.CategoryService;
import com.example.eight0eightdot.service.GeneralService.Image.ImageServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ImageServiceImpl imageService;

    @GetMapping("/find-all")
    public List<CategoryRequest> findAll() {
        return categoryService.categories();
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }
//    @RequestMapping(value = "/update4Delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Category> update(@RequestBody Category category) throws IOException {
//        Optional<Category> categoryFromServer = categoryService.findById(category.getId());
//        categoryFromServer.map(Category::getThumbnail)
//                .map(thumbnailUrl -> thumbnailUrl.substring(thumbnailUrl.lastIndexOf('/') + 1))
//                .ifPresent(fileName -> {
//                    imageService.delete(fileName);
//                    category.setThumbnail("");
//                    ResponseEntity.ok(categoryService.save(category));
//                });
//
//        return ResponseEntity.ok(categoryService.save(category));
//    }
    @GetMapping("/find-with-paging")
    public ResponseEntity<Map<String, Object>> findAllWithPaging(
            @RequestParam(required = false) String slug,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<Category> categories = new ArrayList<Category>();
            Pageable paging = PageRequest.of(page, size);

            Page<Category> pageC;
            if (slug == null) pageC = categoryRepository.findAll(paging);
            else pageC = categoryRepository.findBySlug(slug, paging);
            categories = pageC.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("categories", categories);
            response.put("currentPage", pageC.getNumber());
            response.put("totalItems", pageC.getTotalElements());
            response.put("totalPages", pageC.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
