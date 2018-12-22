package com.store.areas.brand.services;

import com.store.areas.brand.models.service.BrandServiceModel;

import java.util.Set;

public interface BrandService {
    BrandServiceModel findByName(String name);

    void create(BrandServiceModel brandServiceModel);

    boolean doesExist(String name);

    BrandServiceModel createIfNotExistsAndRetrieve(String name);

    Set<BrandServiceModel> findAll();
}
