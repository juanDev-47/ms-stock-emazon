package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper;

import com.emazon.ms_stock.domain.model.Category;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryEntityMapper {
    CategoryEntity toEntity(Category category);
    List<Category> toCategoryList(List<CategoryEntity> categories);
    Category toCategory(CategoryEntity categoryEntity);
}
