package ru.levchenko.service.security.forms;

import lombok.Data;

@Data
public class LoginForm {
    private String login;
    private String password;

}
