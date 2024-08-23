package com.emazon.ms_stock.domain.useCase;

import com.emazon.ms_stock.domain.api.ICategoryServicePort;
import com.emazon.ms_stock.domain.model.Category;
import com.emazon.ms_stock.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort){
        this.categoryPersistencePort = categoryPersistencePort;
    }
    @Override
    public Category saveCategory(Category category) {
        return categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryPersistencePort.getAllCategory();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryPersistencePort.getCategory(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryPersistencePort.updateCategory(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryPersistencePort.deleteCategory(id);
    }
}
