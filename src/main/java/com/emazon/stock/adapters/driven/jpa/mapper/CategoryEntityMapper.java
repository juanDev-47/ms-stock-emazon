package com.emazon.stock.adapters.driven.jpa.mapper;


import com.emazon.stock.domain.model.Category;
import com.emazon.stock.adapters.driven.jpa.entity.CategoryEntity;
import com.emazon.stock.domain.utils.pagination.DomainPage;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryEntityMapper {
    @Mapping(target = "products", ignore = true)
    CategoryEntity toEntity(Category category);

    @Named("toCategoryWithoutProducts")
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryEntity categoryEntity);

    @IterableMapping(qualifiedByName = "toCategoryWithoutProducts")
    List<Category> toCategories(List<CategoryEntity> categoryEntities);

    @Mapping(target = "page", source = "number")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalPages", source = "totalPages")
    @Mapping(target = "count", source = "numberOfElements")
    @Mapping(target = "totalCount", source = "totalElements")
    @Mapping(target = "content", source = "content")
    DomainPage<Category> toDomainPage(Page<CategoryEntity> categoryEntities);
}
