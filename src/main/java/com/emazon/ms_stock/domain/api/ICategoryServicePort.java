package com.emazon.ms_stock.domain.api;

import com.emazon.ms_stock.domain.model.Article;
import com.emazon.ms_stock.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {

    Category saveCategory(Category category);
    List<Category> getAllCategory();
    Category getCategory(Long id);
    void updateCategory(Category category);
    void deleteCategory(Long id);
}
