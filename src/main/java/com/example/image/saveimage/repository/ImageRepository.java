package com.example.image.saveimage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.example.image.saveimage.entity.ImageData;

public interface ImageRepository extends JpaRepository<ImageData, Long>{
    Optional<ImageData> findByName(String fileName);
}
