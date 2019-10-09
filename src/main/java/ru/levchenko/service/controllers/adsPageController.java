package ru.levchenko.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.Product;
import ru.levchenko.service.models.State;
import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.ProductsRepository;
import ru.levchenko.service.security.details.UserDetailsImpl;
import ru.levchenko.service.services.CreateAdsService;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adsPage")
public class adsPageController {

    @Autowired
    CreateAdsService createAdsService;
    @Autowired
    ProductsRepository productsRepository;

    @GetMapping
    public String getAdsPage(Model model) {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();

        List<Product> productList = productsRepository.findAllByStatusAndOwner(State.ACTIVE, user);

        if (!productList.isEmpty()) {
            model.addAttribute("productList", productList);
            model.addAttribute("message", "Нет активных объявлений");
        }
        return "adsPage";

    }

    @GetMapping("active")
    public String getActivePage(Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();

        List<Product> productList = productsRepository.findAllByStatusAndOwner(State.ACTIVE, user);

        if (!productList.isEmpty()) {
            model.addAttribute("productList", productList);
            model.addAttribute("message", "Нет активных объявлений");
        }
        return "adsPage";
    }
    @GetMapping("delete")
    public String getDeletePage(Model model){
        
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();

        List<Product> productList = productsRepository.findAllByStatusAndOwner(State.DELETED, user);

        if (!productList.isEmpty()) {
            model.addAttribute("productList", productList);
            model.addAttribute("message", "Нет закрытых объявлений");
        }
        return "adsPage";
    }


    @GetMapping("create")
    public String getCreateAdsPage() {
        return "createAds";
    }


    @PostMapping("create")
    public String createProduct(@RequestParam("file") MultipartFile file,
                                @RequestParam Map<String, String> form) {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();

        if (user != null) {

            int price = Integer.parseInt(form.get("price"));
            //добавить ошибку если ввели не число

            Product product = Product.builder()
                    .name(form.get("name"))
                    .description(form.get("description"))
                    .price(price)
                    .owner(user)
                    .status(State.ACTIVE)
                    .date(new Date(Calendar.getInstance().getTime().getTime()))
                    .build();


            if (!file.isEmpty()) {
                createAdsService.update(file, product);
                return "redirect:/adsPage";
            } else {

                productsRepository.save(product);
                return "redirect:/adsPage";

            }
        }

        return "redirect:/adsPage";
    }
}
