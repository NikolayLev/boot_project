package ru.levchenko.service.services;

import ru.levchenko.service.models.User;
import ru.levchenko.service.security.forms.UserForm;

import java.util.Optional;

public interface SignUpService {
    boolean signUp(UserForm userForm);
    Optional<User> findByUserName(String userName);

    public boolean checkEmail(String email);
    public boolean checkLogin(String login);
    public boolean checkPassword(String password);

    boolean activateUser(String code);
}
