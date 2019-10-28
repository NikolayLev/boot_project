package ru.levchenko.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.Product;
import ru.levchenko.service.models.State;
import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.ProductsRepository;
import ru.levchenko.service.security.details.UserDetailsImpl;
import ru.levchenko.service.services.CreateAdsService;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * Controllers for /adsPage/*
 * /adsPage return for user list ads
 * /adsPage/active return active ads
 * /adsPage/delete return deleted ads
 * /adsPage/create return create ad page
 * /adsPage/edit{id-Ad} return edit page
 */
@Controller
@RequestMapping("/adsPage")
public class adsPageController {

    @Autowired
    CreateAdsService createAdsService;
    @Autowired
    ProductsRepository productsRepository;

    @GetMapping
    public String getAdsPage(Model model, @AuthenticationPrincipal User user) {

        List<Product> productList = productsRepository.findAllByStatusAndOwner(State.ACTIVE, user);

        if (!productList.isEmpty()) {
            model.addAttribute("productList", productList);
        }
        model.addAttribute("message", "Нет активных объявлений");
        return "adsPage";

    }

    @GetMapping("active")
    public String getActivePage(Model model) {

        List<Product> productList = productsRepository.findAllByStatus(State.ACTIVE);

        if (!productList.isEmpty()) {
            model.addAttribute("productList", productList);
        }
        model.addAttribute("message", "Нет активных объявлений");
        return "adsPage";
    }

    @GetMapping("delete")
    public String getDeletePage(Model model) {

        List<Product> productList = productsRepository.findAllByStatus(State.DELETED);
        model.addAttribute("message", "Нет закрытых объявлений");
        if (!productList.isEmpty()) {
            model.addAttribute("productList", productList);
        }
        return "adsPage";
    }

    @PostMapping("delete/{id}")
    public String createProduct(@PathVariable(value = "id") Long id) {
        Optional<Product> productCandidate = productsRepository.findById(id);
        Product product = productCandidate.orElseThrow(IllegalArgumentException::new);
        product.setStatus(State.DELETED);
        productsRepository.save(product);
        return "redirect:/adsPage";
    }


    @GetMapping("create")
    public String getCreateAdsPage() {
        return "createAds";
    }


    @PostMapping("create")
    public String createProduct(@Valid Product product,
                                BindingResult bindingResult,
                                Model model,
                                @RequestParam("file") MultipartFile file) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();
        product.setOwner(user);

        if (bindingResult.hasErrors()) {

            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("product", product);
            return "createAds";
        } else

            product.setStatus(State.ACTIVE);
        product.setDate(new Date(Calendar.getInstance().getTime().getTime()));

        if (!file.isEmpty()) {
            createAdsService.update(file, product);
            return "redirect:/adsPage";
        } else {
            productsRepository.save(product);
            return "redirect:/adsPage";
        }
    }


    @GetMapping("edit/{product-id}")
    public String getEditPage(@PathVariable("product-id") Long productId,
                              Model model) {
        Optional<Product> productCandidate = productsRepository.findById(productId);
        if (productCandidate.isPresent()) {
            Product product = productCandidate.get();
            model.addAttribute("product", product);
            return "editPage";
        } else {
            return "redirect:/adsPage";
        }

    }

    @PostMapping("edit/{product-id}")
    public String postEditPage(@PathVariable("product-id") Long productId,
                               @Valid Product validProduct,
                               BindingResult bindingResult,
                               Model model,
                               @RequestParam("file") MultipartFile file) {

        Product product = productsRepository.getOne(productId);

        product.setName(validProduct.getName());
        product.setPrice(validProduct.getPrice());
        product.setDescription(validProduct.getDescription());

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("product", product);
            return "editPage";

        } else {

            if (!file.isEmpty()) {
                createAdsService.update(file, product);
                return "redirect:/adsPage";
            } else {
                productsRepository.save(product);
                return "redirect:/adsPage";
            }

        }

    }

}


