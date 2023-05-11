package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.ProductImageReq;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductImageService {
    boolean saveNewImage(List<ProductImageReq> productImageReqs);

    void deleteImageProduct(Long id);

    List<String> uploadImageProduct(Long productId, List<MultipartFile> imgs);

}
