package ru.levchenko.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.levchenko.service.models.User;
import ru.levchenko.service.services.SignUpService;
import ru.levchenko.service.services.ValidationService;


import javax.validation.Valid;
import java.util.Map;


@Controller
public class SignUpController {

    @Autowired
    private SignUpService service;
    @Autowired
    private ValidationService validationService;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);

            return "signUp";
        } else {

            if (!service.signUp(user)) {
                model.addAttribute("message", "User с таким логином уже есть в базе");
                return "signUp";
            }
            model.addAttribute("message", "Проверьте ваш емейл");
            return "login";
        }
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = service.activateUser(code);
        if (isActivated) {
            model.addAttribute("message", "User is Activated - Congratulations");
        } else {
            model.addAttribute("message", "Error, activation code not found");
        }
        model.addAttribute("message", "Ваш аккаунт активирован");
        return "login";

    }
}