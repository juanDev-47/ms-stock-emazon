package com.emazon.ms_stock.application.handler;

import com.emazon.ms_stock.application.dto.CategoryDTO;
import com.emazon.ms_stock.application.mapper.CategoryDTOMapper;
import com.emazon.ms_stock.domain.api.ICategoryServicePort;
import com.emazon.ms_stock.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler{
    private final ICategoryServicePort categoryServicePort;
    private final CategoryDTOMapper categoryDTOMapper;

    @Override
    public void saveCategory(CategoryDTO category) {
        Category newCategory = categoryDTOMapper.toEntity(category);
        categoryServicePort.saveCategory(newCategory);
    }

    @Override
    public List<CategoryDTO> getAllCategories(Integer page, Integer size, String order) {
        List<Category> categories = categoryServicePort.getAllCategory(page, size, order);
        return categoryDTOMapper.toDtoList(categories);
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        Category category = categoryServicePort.getCategory(id);
        return categoryDTOMapper.toDto(category);
    }

    @Override
    public void updateCategory(CategoryDTO category) {
        Category oldCategory = categoryServicePort.getCategory(category.getId());
        Category newCategory = categoryDTOMapper.toEntity(category);
        newCategory.setId(oldCategory.getId());
        categoryServicePort.updateCategory(newCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryServicePort.getCategory(id);
        categoryServicePort.deleteCategory(category.getId());
    }
}
