package com.store.areas.products.controllers;

import com.store.abstractions.controller.BaseController;
import com.store.areas.products.models.binding.CreateProductBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController {

    @GetMapping("/create")
    public ModelAndView create(@ModelAttribute CreateProductBindingModel bindingModel) {
        return super.view("views/products/create");
    }
}