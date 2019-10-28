package ru.levchenko.service.services;

import java.util.regex.Pattern;

public interface ValidationService {
    public boolean checkEmail(String email);
    public boolean checkLogin(String login);
    public boolean checkPassword(String password);

}
