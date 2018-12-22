package com.store.areas.brand.repositories;

import com.store.areas.brand.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    Brand findByName(String name);

    boolean existsByName(String name);
}
