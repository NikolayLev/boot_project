package ru.levchenko.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.Product;
import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.ProductsRepository;
import ru.levchenko.service.repositories.UsersRepository;
import ru.levchenko.service.security.forms.ProductForm;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class CreateAdsServiceImpl implements CreateAdsService {

    @Value("${upload.pathProduct}")
    private String uploadPath;

    @Autowired
    private ProductsRepository productsRepository;


    //метод можно использовать для создания нового пользователя и сохранения фото старому
    @Override
    public void update(MultipartFile file, Product product) {

        if (file != null) {

            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
                System.out.println("Создали папку");
            }

            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + filename;

            try {
                file.transferTo(new File(uploadPath + "/" + resultFileName));
                product.setFileName(resultFileName);
                productsRepository.save(product);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void create(MultipartFile file, ProductForm productForm, User owner) {

        Product product = Product.builder()
                .name(productForm.getName())
                .price(productForm.getPrice())
                .description(productForm.getDescription())
                .owner(owner)
                .build();

        if (file != null) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
                System.out.println("Создали папку");
            }

            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + filename;

            try {
                file.transferTo(new File(uploadPath + "/" + resultFileName));

                product.setFileName(resultFileName);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        productsRepository.save(product);
    }

    @Override
    public void create(ProductForm productForm) {

    }
}
