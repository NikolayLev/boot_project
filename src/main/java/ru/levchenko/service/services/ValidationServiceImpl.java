package ru.levchenko.service.services;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * custom validation for form sign in/up, profile pages
 */
@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        return email.matches(pattern.pattern());
    }

    @Override
    public boolean checkLogin(String login) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{4,16}");
        return login.matches(pattern.pattern());
    }

    @Override
    public boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("[._a-zA-Z0-9!#$@%&,:;'\"'*+-/=?^_`{|}~\\.]{8,16}");
        return password.matches(pattern.pattern());
    }
}
