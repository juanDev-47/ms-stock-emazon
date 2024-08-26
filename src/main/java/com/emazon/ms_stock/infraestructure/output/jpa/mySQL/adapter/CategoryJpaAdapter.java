package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.adapter;

import com.emazon.ms_stock.domain.model.Category;
import com.emazon.ms_stock.domain.spi.ICategoryPersistencePort;
import com.emazon.ms_stock.infraestructure.exception.CategoryAlreadyExistException;
import com.emazon.ms_stock.infraestructure.exception.CategoryNotFoundException;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.CategoryEntity;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper.CategoryEntityMapper;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    public List<Category> getAllCategory(Integer page, Integer size, String order) {
        Sort sort = Sort.by(order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, "name");
        Pageable pagination = PageRequest.of(page, size, sort);
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll(pagination).getContent();
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
