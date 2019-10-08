package ru.levchenko.service.services;

import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.Product;
import ru.levchenko.service.models.User;

public interface ProfileUploadFormService {

    void store(MultipartFile file, User user);
}
