package ru.levchenko.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * not ready main page
 * have only navigation bar
 */
@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String getMainPage(){
        return "main";
    }
}
