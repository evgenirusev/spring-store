package com.store.areas.product.repositories;

import com.store.areas.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByName(String name);

    Set<Product> findAllByNameContaining(String name);
}
