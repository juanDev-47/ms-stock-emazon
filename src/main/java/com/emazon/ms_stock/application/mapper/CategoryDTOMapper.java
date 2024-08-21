package com.emazon.ms_stock.application.mapper;

import com.emazon.ms_stock.application.dto.CategoryDTO;
import com.emazon.ms_stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryDTOMapper {
    CategoryDTO toDto(Category category);
    List<CategoryDTO> toDtoList(List<Category> categories);
    Category toEntity(CategoryDTO dto);
}
