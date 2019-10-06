package ru.levchenko.service.services;

import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.User;

public interface UploadFormService {

    void store(MultipartFile file, User user);
}
