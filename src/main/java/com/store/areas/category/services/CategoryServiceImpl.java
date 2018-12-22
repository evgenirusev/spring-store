package com.store.areas.category.services;

import com.store.areas.category.entities.Category;
import com.store.areas.category.models.service.CategoryServiceModel;
import com.store.areas.category.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(CategoryServiceModel categoryServiceModel) {
        Category category = this.modelMapper.map(categoryServiceModel, Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public CategoryServiceModel findByName(String name) {
        Category category = this.categoryRepository.findByName(name);
        CategoryServiceModel categoryServiceModel = this.modelMapper.map(category, CategoryServiceModel.class);
        return categoryServiceModel;
    }

    @Override
    public Set<CategoryServiceModel> findAll() {
        Set<CategoryServiceModel> categoryServiceModels = new HashSet<>();
        this.categoryRepository.findAll().forEach(category -> {
            CategoryServiceModel serviceModel = this.modelMapper.map(category, CategoryServiceModel.class);
            categoryServiceModels.add(serviceModel);
        });
        return categoryServiceModels;
    }

    @Override
    public CategoryServiceModel findById(String id) {
        Category categoryEntity = this.categoryRepository.findById(id).orElse(null);
        return this.modelMapper.map(categoryEntity, CategoryServiceModel.class);
    }
}