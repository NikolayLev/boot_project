package ru.levchenko.service.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.UsersRepository;
import ru.levchenko.service.security.details.UserDetailsImpl;
import ru.levchenko.service.services.ProfileUploadFormService;


import java.util.Map;


@Controller
public class ProfileUploadController {

    UsersRepository usersRepository;
    ProfileUploadFormService uploadFormService;

    @Autowired
    public ProfileUploadController(ProfileUploadFormService uploadFormService, UsersRepository usersRepository) {
        this.uploadFormService = uploadFormService;
        this.usersRepository = usersRepository;
    }


    @GetMapping("/profile")
    public String listUploadedFiles(Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();
        if (user != null) {
            model.addAttribute("user1", user);
            if (user.getUploadPhoto() != null) {
                model.addAttribute("image", user.getUploadPhoto());
            }
        }
        return "profile";
    }


    @PostMapping("/profile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam Map<String, String> form) {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();
        if (user != null) {
            user.setFirstName(form.get("firstName"));
            user.setLastName(form.get("lastName"));
            if(!file.isEmpty()){
            uploadFormService.store(file, user);
        }else {
            usersRepository.save(user);

            }
        }
        return "redirect:/profile";
    }



}

