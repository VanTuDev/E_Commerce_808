package com.example.eight0eightdot.repository;

import com.example.eight0eightdot.entity.General.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImageRepository extends JpaRepository<Image, Long>, JpaSpecificationExecutor<Image> {
}
