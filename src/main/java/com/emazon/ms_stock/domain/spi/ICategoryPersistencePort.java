package com.emazon.ms_stock.domain.spi;

import com.emazon.ms_stock.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    Category saveCategory(Category category);
    List<Category> getAllCategory(Integer page, Integer size, String order);
    Category getCategory(Long id);
    void updateCategory(Category category);
    void deleteCategory(Long id);
}
