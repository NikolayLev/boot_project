package ru.levchenko.service.services;

import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.User;

import java.io.IOException;

public interface UploadFormService {

    public void store(MultipartFile file, User user);
}
