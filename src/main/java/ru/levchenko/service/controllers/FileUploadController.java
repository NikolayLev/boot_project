package ru.levchenko.service.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.levchenko.service.models.User;
import ru.levchenko.service.security.details.UserDetailsImpl;
import ru.levchenko.service.services.UploadFormService;



@Controller
public class FileUploadController {


    UploadFormService uploadFormService;

    @Autowired
    public FileUploadController(UploadFormService uploadFormService) {
        this.uploadFormService = uploadFormService;
        }


    @GetMapping("/uploadForm")
    public String listUploadedFiles(Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();
        if (user!=null) {
            if (user.getUploadPhoto() != null) {
                model.addAttribute("image", user.getUploadPhoto());
            }
        }
        return "uploadForm";
    }



    @PostMapping("/uploadForm")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();
        uploadFormService.store(file,user);


        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }


    }

