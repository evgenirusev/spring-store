package com.store.areas.product.controllers;

import com.store.abstractions.controller.BaseController;
import com.store.areas.brand.models.service.BrandServiceModel;
import com.store.areas.brand.services.BrandService;
import com.store.areas.category.models.service.CategoryServiceModel;
import com.store.areas.category.models.view.CategoryViewModel;
import com.store.areas.category.services.CategoryService;
import com.store.areas.product.models.binding.CreateProductBindingModel;
import com.store.areas.product.models.service.ProductServiceModel;
import com.store.areas.product.services.ProductService;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController {

    private final ModelMapper modelMapper;

    private final ProductService productService;

    private final CategoryService categoryService;

    private final UserService userService;

    private final BrandService brandService;

    @Autowired
    public ProductController(ModelMapper modelMapper, ProductService productService, CategoryService categoryService, UserService userService, BrandService brandService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.brandService = brandService;
    }

    @GetMapping("/create")
    public ModelAndView create(@ModelAttribute CreateProductBindingModel bindingModel) {
        List<CategoryViewModel> categoryViewModels = new ArrayList<>();
        this.categoryService.findAllCategories().forEach(categoryServiceModel -> {
            CategoryViewModel categoryViewModel =
                    this.modelMapper.map(categoryServiceModel, CategoryViewModel.class);
            categoryViewModels.add(categoryViewModel);
        });
        return super.view("views/products/create", categoryViewModels);
    }

    @PostMapping("create")
    public ModelAndView createConfirm(@ModelAttribute CreateProductBindingModel bindingModel, Authentication authentication) {
        ProductServiceModel productServiceModel = this.modelMapper.map(bindingModel, ProductServiceModel.class);
        UserServiceModel userServiceModel = this.userService.findByUsername(authentication.getName());
        productServiceModel.setUser(userServiceModel);
        productServiceModel.setCreatedAt(LocalDateTime.now());
        BrandServiceModel brandServiceModel = this.brandService.createIfNotExistsAndRetrieve(bindingModel.getBrand());
        productServiceModel.setBrand(brandServiceModel);
        Set<CategoryServiceModel> categoryServiceModels = new HashSet<>();
        for (String categoryId : bindingModel.getCategories()) {
            CategoryServiceModel categoryServiceModel = this.categoryService.findById(categoryId);
            categoryServiceModels.add(categoryServiceModel);
        }
        productServiceModel.setCategories(categoryServiceModels);
        productService.create(productServiceModel);
        return super.redirect("/");
    }

    @GetMapping("")
    public ModelAndView all() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);
        ints.add(9);
        ints.add(10);
        return super.view("/views/products/all", ints);
    }

}