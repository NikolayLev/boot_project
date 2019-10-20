package ru.levchenko.service.services;

import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.Product;
import ru.levchenko.service.models.User;

public interface ProfileUpdateFormService {


    void store(MultipartFile file, User user);

    boolean updateEmail(User user, String email);
    boolean updatePassword(User user, String password);
}
