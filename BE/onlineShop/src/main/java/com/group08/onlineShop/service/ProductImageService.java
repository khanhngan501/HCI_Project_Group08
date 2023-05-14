package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.ProductImageReq;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductImageService {
    List<String>  saveNewImage(Long productId, List<MultipartFile> productImageReqs, String color, Integer isDefault);

    void deleteImageProduct(Long id);


}
