package com.store.areas.product.models.view;

import com.store.areas.brand.models.view.BrandViewModel;
import com.store.areas.category.models.view.CategoryViewModel;

import java.util.Set;

public class AllProductsViewModel {
    private Set<ProductViewModel> products;

    private Set<CategoryViewModel> categories;

    private Set<BrandViewModel> brands;

    public Set<ProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductViewModel> products) {
        this.products = products;
    }

    public Set<CategoryViewModel> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryViewModel> categories) {
        this.categories = categories;
    }

    public Set<BrandViewModel> getBrands() {
        return brands;
    }

    public void setBrands(Set<BrandViewModel> brands) {
        this.brands = brands;
    }
}
