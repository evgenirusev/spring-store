package com.store.areas.user.controllers;

import com.store.abstractions.controller.BaseController;
import com.store.areas.recaptcha.service.RecaptchaService;
import com.store.areas.sale.models.view.SaleViewModel;
import com.store.areas.sale.services.SaleService;
import com.store.areas.user.models.binding.UserRegisterBindingModel;
import com.store.areas.user.models.service.UserServiceModel;
import com.store.areas.user.models.view.ProfileViewModel;
import com.store.areas.user.models.view.UserViewModel;
import com.store.areas.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController extends BaseController {

    private final UserService userService;

    private final SaleService saleService;

    private final ModelMapper modelMapper;

    private final RecaptchaService recaptchaService;

    @Autowired
    public UserController(UserService userService, SaleService saleService, ModelMapper modelMapper, RecaptchaService recaptchaService) {
        this.userService = userService;
        this.saleService = saleService;
        this.modelMapper = modelMapper;
        this.recaptchaService = recaptchaService;
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel) {
        return super.view("views/users/register", "Register");
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@Valid @ModelAttribute UserRegisterBindingModel userRegisterBindingModel,
                                        BindingResult bindingResult,
                                        @RequestParam(name = "g-recaptcha-response") String gRecaptchaResponse,
                                        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return super.view("views/users/register", "Register");
        }

        if (!this.recaptchaService.verifyRecaptcha(request.getRemoteAddr(), gRecaptchaResponse).equals("success")) {
            return super.redirect("/register");
        }

        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        this.userService.create(userServiceModel);
        return super.redirect("/login");
    }

    @GetMapping("/login")
    public ModelAndView login(String error, ModelAndView mav) {
        mav.addObject("viewName", "/views/users/login");
        mav.setViewName("layout");
        if (error != null) {
            mav.addObject("error", "Wrong username or password");
        }
        return mav;
    }

    @GetMapping("/users/{username}")
    public ModelAndView userProfile(@PathVariable String username) {
        UserServiceModel userServiceModel = this.userService.findByUsername(username);
        UserViewModel userViewModel = this.modelMapper.map(userServiceModel, UserViewModel.class);

        List<SaleViewModel> sales = new ArrayList<>();
        this.saleService.findSalesByUsername(username).forEach(saleServiceModel -> {
            SaleViewModel saleViewModel = this.modelMapper.map(saleServiceModel, SaleViewModel.class);
            sales.add(saleViewModel);
        });

        ProfileViewModel profileViewModel = new ProfileViewModel();
        profileViewModel.setUser(userViewModel);
        profileViewModel.setSales(sales);

        return super.view("/views/users/profile", profileViewModel);
    }
}