package com.store.areas.brand.services;

import com.store.areas.brand.entities.Brand;
import com.store.areas.brand.models.service.BrandServiceModel;
import com.store.areas.brand.repositories.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandServiceModel findByName(String name) {
        Brand brandEntity = this.brandRepository.findByName(name);
        return this.modelMapper.map(brandEntity, BrandServiceModel.class);
    }

    @Override
    public void create(BrandServiceModel brandServiceModel) {
        Brand brandEntity = this.modelMapper.map(brandServiceModel, Brand.class);
        this.brandRepository.save(brandEntity);
    }

    @Override
    public boolean doesExist(String name) {
        return this.brandRepository.findByName(name) != null;
    }

    @Override
    public BrandServiceModel createIfNotExistsAndRetrieve(String name) {
        boolean doesBrandExist = this.brandRepository.existsByName(name);
        Brand brand = null;

        // Refactor
        if (doesBrandExist) {
            brand = this.brandRepository.findByName(name);
        } else {
            Brand newBrand = new Brand();
            newBrand.setName(name);
            this.brandRepository.save(newBrand);
            brand = this.brandRepository.findByName(name);
        }

        return this.modelMapper.map(brand, BrandServiceModel.class);
    }
}
