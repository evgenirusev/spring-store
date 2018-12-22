package com.store.areas.brand.controllers;

import com.store.abstractions.controller.BaseController;
import com.store.areas.brand.models.view.BrandViewModel;
import com.store.areas.brand.services.BrandService;
import com.store.areas.category.models.view.CategoryViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping("/brands")
public class BrandController extends BaseController {

    private final BrandService brandService;

    private final ModelMapper modelMapper;

    @Autowired
    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public ModelAndView all() {
        Set<BrandViewModel> brandViewModels = new TreeSet<BrandViewModel>(Comparator.comparing(BrandViewModel::getName));
        this.brandService.findAll().forEach(brandServiceModel -> {
            BrandViewModel brandViewModel = this.modelMapper.map(brandServiceModel, BrandViewModel.class);
            brandViewModels.add(brandViewModel);
        });
        return super.view("views/brands/all", brandViewModels);
    }
}
