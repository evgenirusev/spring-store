package com.store.areas.category.controllers;

import com.store.abstractions.controller.BaseController;
import com.store.areas.category.models.binding.CategoryBindingModel;
import com.store.areas.category.models.service.CategoryServiceModel;
import com.store.areas.category.models.view.CategoryNamesViewModel;
import com.store.areas.category.models.view.CategoryViewModel;
import com.store.areas.category.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping("/categories")
public class CategoryController extends BaseController {

    private final CategoryService categoryService;

    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create")
    public ModelAndView createCategory(@ModelAttribute CategoryBindingModel categoryBindingModel) {
        return super.view("/views/categories/create", "Create Category");
    }

    @PostMapping("/create")
    public ModelAndView persistCategory(@Valid @ModelAttribute CategoryBindingModel categoryBindingModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return super.view("/views/categories/create", "Create Category");
        }

        CategoryServiceModel categoryServiceModel = this.modelMapper.map(categoryBindingModel, CategoryServiceModel.class);
        this.categoryService.create(categoryServiceModel);
        return super.redirect("/categories");
    }

    @GetMapping("")
    public ModelAndView allCategories() {
        Set<CategoryViewModel> categoryViewModels
                = new TreeSet<CategoryViewModel>(Comparator.comparing(CategoryViewModel::getId));
        this.categoryService.findAllCategories().forEach(categoryServiceModel -> {
            CategoryViewModel categoryViewModel = this.modelMapper.map(categoryServiceModel, CategoryViewModel.class);
            categoryViewModels.add(categoryViewModel);
        });
        return super.view("views/categories/all", categoryViewModels);
    }

    @GetMapping("/{categoryName}")
    public ModelAndView findPostsByCategory(@PathVariable String categoryName) {
        CategoryServiceModel categoryServiceModel = this.categoryService.findByName(categoryName);
        return super.view("views/categories/products-by-category", categoryServiceModel);
    }
}