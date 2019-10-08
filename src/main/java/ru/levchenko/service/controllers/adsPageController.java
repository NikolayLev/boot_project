package ru.levchenko.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adsPage")
public class adsPageController {

    @GetMapping
    public String getAdsPage(){
        return "adsPage";
    }


    @GetMapping("create")
    public String getCreateAdsPage(){
        return "createAds";
    }
    @GetMapping("private")
    public String getCreateAdsPage1(){
        return "private";
    }
}
