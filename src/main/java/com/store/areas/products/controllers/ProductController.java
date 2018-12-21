package com.store.areas.products.controllers;

import com.store.abstractions.controller.BaseController;
import com.store.areas.products.models.binding.CreateProductBindingModel;
import com.store.areas.products.models.service.ProductServiceModel;
import com.store.areas.products.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController {

    private final ModelMapper modelMapper;

    private final ProductService productService;

    @Autowired
    public ProductController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @GetMapping("/create")
    public ModelAndView create(@ModelAttribute CreateProductBindingModel bindingModel) {
        return super.view("views/products/create");
    }

    @PostMapping("create")
    public ModelAndView createConfirm(@ModelAttribute CreateProductBindingModel bindingModel) {
        // TODO: persist
        return super.redirect("/");
    }
}