package ru.levchenko.service.services;

import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.Product;


public interface CreateAdsService {

    void store(MultipartFile file, Product product);
}
