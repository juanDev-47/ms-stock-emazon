package com.emazon.ms_stock.domain.spi;

import com.emazon.ms_stock.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);
    List<Category> getAllCategory();
    Category getCategory(Long id);
    void updateCategory(Category category);
    void deleteCategory(Long id);
}
