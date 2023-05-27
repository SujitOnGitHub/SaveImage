package com.example.image.saveimage.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.image.saveimage.entity.ImageData;
import com.example.image.saveimage.repository.ImageRepository;
import com.example.image.saveimage.util.ImageUtil;

@Service
public class ImageService {
    
    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException{
       ImageData imageData = imageRepository.save(ImageData.builder()
        .name(file.getOriginalFilename())
        .type(file.getContentType())
        .imageData(ImageUtil.compressImage(file.getBytes())).build()
        );

        if(imageData != null){
            return "file uploaded successfully"+ file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData =  imageRepository.findByName(fileName);
        byte[] images =  ImageUtil.decompressImage(dbImageData.get().getImageData());
        return images;
    }

}
