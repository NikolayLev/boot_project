package ru.levchenko.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.levchenko.service.security.forms.UserForm;
import ru.levchenko.service.services.SignUpService;

import java.util.Map;


@Controller
public class SignUpController {

    @Autowired
    private SignUpService service;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm userForm, Map<String, Object> model) {
        if(!service.signUp(userForm)){
            model.put("message", "User с таким логином уже есть в базе");
            return "signUp";
        }
        return "/login";
    }
}