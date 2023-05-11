package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.requestDTO.ProductImageReq;
import com.group08.onlineShop.exception.AppException;
import com.group08.onlineShop.model.Product;
import com.group08.onlineShop.model.ProductImage;
import com.group08.onlineShop.repository.ProductImageRepo;
import com.group08.onlineShop.repository.ProductRepo;
import com.group08.onlineShop.service.Cloudinary.CloudinaryUpload;
import com.group08.onlineShop.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImageServiceimpl implements ProductImageService {
    private final ProductRepo productRepo;
    private final ProductImageRepo productImageRepo;
    private final CloudinaryUpload cloudinaryUpload;

    @Override
    public boolean saveNewImage(List<ProductImageReq> productImageReqs) {
        List<ProductImage> productImages = new ArrayList<>();
        productImageReqs.forEach(image -> {
            Product product = productRepo.getReferenceById(image.getProductId());
            productImages.add(new ProductImage(null,product,image.getUrlImage(),image.getIsDefault(),image.getColor()));
        });
        return productImageRepo.saveAll(productImages).size() > 0;
    }

    @Override
    public void deleteImageProduct(Long id) {
        ProductImage productImage= productImageRepo.findById(id).orElse(null);
        if (productImage==null)
            throw new AppException(404, "ID image product not found");
        try{
            if (productImage.getImageLink().startsWith("https://res.cloudinary.com/quangdangcloud/image/upload")) {
                cloudinaryUpload.deleteImage(productImage.getImageLink());
            }
            productImageRepo.deleteById(id);
        } catch (Exception e) {
            throw new AppException(400, e.getMessage());
        }

    }

    @Override
    public List<String> uploadImageProduct(Long productId, List<MultipartFile> imgs) {
        List<ProductImage> productImages = new ArrayList<>();
        imgs.forEach(img ->{
            Product product = productRepo.getReferenceById(productId);
            try {
                String url = cloudinaryUpload.uploadImage(img,null);
                productImages.add(new ProductImage(null,product,url,null,null));
            } catch (IOException e) {
                throw new AppException(400,"Failed");
            }
        });
        productImageRepo.saveAll(productImages);
        List<String> urls = new ArrayList<>();
        productImages.forEach(productImage -> {
            urls.add(productImage.getImageLink());
        });
        return urls;

    }
}
