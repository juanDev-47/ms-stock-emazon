package com.emazon.ms_stock.application.mapper;

import com.emazon.ms_stock.application.dto.CategoryDTO;
import com.emazon.ms_stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryDTOMapper {
    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO dto);
}
