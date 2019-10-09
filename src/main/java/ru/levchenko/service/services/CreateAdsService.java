package ru.levchenko.service.services;

import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.Product;
import ru.levchenko.service.models.User;
import ru.levchenko.service.security.forms.ProductForm;


public interface CreateAdsService {

    void update(MultipartFile file, Product product);

    void create(MultipartFile file, ProductForm productForm, User owner);

    void create(ProductForm productForm);

}
