package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.adapter;

import com.emazon.ms_stock.domain.model.Category;
import com.emazon.ms_stock.domain.spi.ICategoryPersistencePort;
import com.emazon.ms_stock.infraestructure.exception.CategoryAlreadyExistException;
import com.emazon.ms_stock.infraestructure.exception.CategoryNotFoundException;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.CategoryEntity;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper.CategoryEntityMapper;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {
    private final CategoryEntityMapper categoryEntityMapper;
    private final ICategoryRepository categoryRepository;


    @Override
    public Category saveCategory(Category category_one) {
        if(categoryRepository.findCategoryEntitiesByName(category_one.getName()).isPresent() ){
            throw new CategoryAlreadyExistException();
        }
        CategoryEntity categoryEntity = categoryEntityMapper.toEntity(category_one);
        categoryRepository.save(categoryEntity);
        return category_one;
    }

    @Override
    public List<Category> getAllCategory() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        if(categoryEntityList.isEmpty()){
            throw new CategoryNotFoundException();
        }
        return categoryEntityMapper.toCategoryList(categoryEntityList);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryEntityMapper.toCategory(categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new));
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
