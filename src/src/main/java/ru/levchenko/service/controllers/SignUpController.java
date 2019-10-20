package ru.levchenko.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import ru.levchenko.service.models.User;
import ru.levchenko.service.models.dto.CaptchaResponseDto;
import ru.levchenko.service.services.SignUpService;
import ru.levchenko.service.services.ValidationService;


import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;


@Controller
public class SignUpController {

    @Value("${recaptcha.secret}")
    private String recaptchaSecret;
    @Value("${recaptcha.url}")
    private String recaptchaPost;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SignUpService service;
    @Autowired
    private ValidationService validationService;

    @GetMapping("/signUp")
    public String getSignUpPage(Authentication authentication,Model model) {
        if (authentication != null) {
            return "redirect:/";
        }
        model.addAttribute("user", new User());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(
            @RequestParam("g-recaptcha-response") String recaptchaResponse,
            @RequestParam("passwordConfirm") String passwordConfirm,
            @Valid User user,
            BindingResult bindingResult,
            Model model) {

        String url = String.format(recaptchaPost,recaptchaSecret,recaptchaResponse);
        CaptchaResponseDto captchaResponse= restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);

        if (!captchaResponse.isSuccess()){
            model.addAttribute("captchaError", "Убить всех человеков...10111001 ");
        }


        boolean isConfirmed = !StringUtils.isEmpty(passwordConfirm);
        if (!user.getPassword().equals(passwordConfirm)){
            isConfirmed=false;
        }

        if (!isConfirmed || bindingResult.hasErrors() || !captchaResponse.isSuccess()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("passwordConfirmError", "Пароль не совпадают");

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