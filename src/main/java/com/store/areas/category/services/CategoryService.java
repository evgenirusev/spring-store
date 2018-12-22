package com.store.areas.category.services;

import com.store.areas.category.models.service.CategoryServiceModel;

import java.util.Set;

public interface CategoryService {
    void create(CategoryServiceModel categoryServiceModel);

    CategoryServiceModel findByName(String name);

    Set<CategoryServiceModel> findAll();

    CategoryServiceModel findById(String id);
}
