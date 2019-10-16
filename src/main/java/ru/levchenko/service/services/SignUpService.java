package ru.levchenko.service.services;

import ru.levchenko.service.models.User;
import ru.levchenko.service.security.forms.UserForm;

import java.util.Optional;

public interface SignUpService {
    boolean signUp(UserForm userForm);
    boolean signUp(User user);
    Optional<User> findByUserName(String userName);
    boolean activateUser(String code);
}
