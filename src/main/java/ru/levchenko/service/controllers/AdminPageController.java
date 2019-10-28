package ru.levchenko.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.levchenko.service.models.Role;
import ru.levchenko.service.models.State;
import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.UsersRepository;
import ru.levchenko.service.services.AdminPageService;

import java.util.Map;

/**
 * Controller for AdminPage
 * /adminPage return page only for Admins
 * Admins can ban/unban users in /adminPage
 * Admins can see all users in our application
 * Admins can change user data
 */
@Controller
@RequestMapping("adminPage")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminPageController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AdminPageService adminPageService;

    @GetMapping
    public String getAdminPage(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "adminPage";
    }

    @GetMapping("{userId}")
    public String userEditForm(@PathVariable Long userId, Model model) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("user1", user);
        model.addAttribute("role", Role.ADMIN);
        model.addAttribute("status", State.ACTIVE);
        return "userEdit";
    }

    @PostMapping
    public String editUser(
            @RequestParam Map<String, String> form,
            @RequestParam("userId") Long id) {

        adminPageService.editUser(form, id);

        return "redirect:/adminPage";

    }

}
