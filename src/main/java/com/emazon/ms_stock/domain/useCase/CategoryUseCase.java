package com.emazon.ms_stock.domain.useCase;

import com.emazon.ms_stock.domain.api.ICategoryServicePort;
import com.emazon.ms_stock.domain.model.Category;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryServicePort categoryServicePort;

    public CategoryUseCase(ICategoryServicePort categoryServicePort){
        this.categoryServicePort = categoryServicePort;
    }
    @Override
    public void saveCategory(Category category) {
        categoryServicePort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryServicePort.getAllCategory();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryServicePort.getCategory(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryServicePort.updateCategory(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryServicePort.deleteCategory(id);
    }
}
