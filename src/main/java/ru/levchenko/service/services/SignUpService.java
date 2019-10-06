package ru.levchenko.service.services;

import ru.levchenko.service.models.User;
import ru.levchenko.service.security.forms.UserForm;

import java.util.Optional;

public interface SignUpService {
    boolean signUp(UserForm userForm);
    Optional<User> findByUserName(String userName);
}
