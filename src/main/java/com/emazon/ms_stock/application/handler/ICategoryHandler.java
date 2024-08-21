package com.emazon.ms_stock.application.handler;

import com.emazon.ms_stock.application.dto.BrandDTO;
import com.emazon.ms_stock.application.dto.CategoryDTO;

import java.util.List;

public interface ICategoryHandler {
    void saveCategory(CategoryDTO category);
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategory(Long id);
    void updateCategory(CategoryDTO Category);
    void deleteCategory(Long id);
}
