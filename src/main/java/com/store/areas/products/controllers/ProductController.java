package com.store.areas.products.controllers;

import com.store.abstractions.controller.BaseController;
import com.store.areas.products.models.binding.CreateProductBindingModel;
import com.store.areas.products.models.service.ProductServiceModel;
import com.store.areas.products.services.ProductService;
import com.store.areas.user.models.service.UserServiceModel;
import com.store.areas.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController {

    private final ModelMapper modelMapper;

    private final ProductService productService;

    private final UserService userService;

    @Autowired
    public ProductController(ModelMapper modelMapper, ProductService productService, UserService userService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public ModelAndView create(@ModelAttribute CreateProductBindingModel bindingModel) {
        return super.view("views/products/create");
    }

    @PostMapping("create")
    public ModelAndView createConfirm(@ModelAttribute CreateProductBindingModel bindingModel, Authentication authentication) {
        ProductServiceModel productServiceModel = this.modelMapper.map(bindingModel, ProductServiceModel.class);
        UserServiceModel userServiceModel = this.userService.findByUsername(authentication.getName());
        productServiceModel.setUserServiceModel(userServiceModel);
        productServiceModel.setCreatedAt(LocalDateTime.now());
        productService.create(productServiceModel);
        return super.redirect("/");
    }
}