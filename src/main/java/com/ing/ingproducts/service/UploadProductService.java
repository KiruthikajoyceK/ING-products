package com.ing.ingproducts.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadProductService {
 public String upload(MultipartFile file);
}
