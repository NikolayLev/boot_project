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
import ru.levchenko.service.services.ProfileUpdateFormService;
import ru.levchenko.service.services.SignUpService;

import java.util.Map;

/**
 * Profile controller return profile page
 * profile page user use for change his profile, name, password, email and profileImage
 */
@Controller
public class ProfileUpdateController {

    UsersRepository usersRepository;
    ProfileUpdateFormService uploadFormService;
    SignUpService service;


    @Autowired
    public ProfileUpdateController(ProfileUpdateFormService uploadFormService, UsersRepository usersRepository,
                                   SignUpService signUpService) {

        this.uploadFormService = uploadFormService;
        this.usersRepository = usersRepository;
        this.service = signUpService;

    }

    /**
     * @param errEmail    if we have problem with validate new email user return error on page
     * @param errPassword if we have problem with validate new password user return error on page
     * @param model
     * @return
     */
    @GetMapping("/profile")
    public String listUploadedFiles(@RequestParam(name = "errEmail", required = false) String errEmail,
                                    @RequestParam(name = "errPass", required = false) String errPassword,
                                    Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();

        if (user != null) {
            model.addAttribute("user1", user);
            if (user.getUploadPhoto() != null) {
                model.addAttribute("image", user.getUploadPhoto());
            }
        }

        if (errEmail != null && errPassword != null) {
            if (errEmail.equals("true")) {
                model.addAttribute("errEmail", true);
            }
            if (errPassword.equals("true")) {
                model.addAttribute("errPass", true);
            }
        }
        return "profile";
    }

    /**
     * @param file file for user image, we get file from this page and safe image on our server
     * @param form user form for change profile information
     * @return
     */
    @PostMapping("/profile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam Map<String, String> form) {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();

        if (user != null) {

            String email = form.get("email");
            String password = form.get("password");

            boolean correctEmail = uploadFormService.updateEmail(user, email);
            boolean correctPassword = uploadFormService.updatePassword(user, password);

            if (!correctEmail || !correctPassword) {
                String emailError = (!correctEmail ? "?errEmail=true" : "?errEmail=false");
                String passwordError = (!correctPassword ? "&errPass=true" : "&errPass=false");

                return "redirect:/profile" + emailError + passwordError;
            }

            user.setFirstName(form.get("firstName"));
            user.setLastName(form.get("lastName"));

            if (!file.isEmpty()) {
                uploadFormService.store(file, user);
            } else {
                usersRepository.save(user);

            }
        }
        return "redirect:/profile";
    }


}

