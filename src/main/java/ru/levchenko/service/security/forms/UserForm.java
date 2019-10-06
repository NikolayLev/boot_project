package ru.levchenko.service.security.forms;

import lombok.Data;

@Data
public class UserForm {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
}
