package com.emazon.stock.adapters.driven.jpa.mapper;


import com.emazon.stock.adapters.driven.jpa.entity.BrandEntity;
import com.emazon.stock.adapters.driven.jpa.entity.ProductEntity;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Product;
import com.emazon.stock.domain.utils.pagination.DomainPage;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrandEntityMapper {
    @Mapping(target = "products", ignore = true)
    BrandEntity toEntity(Brand brand);

    @Named("brandWithoutProducts")
    @Mapping(target = "products", ignore = true)
    Brand toBrand(BrandEntity brandEntity);

    @IterableMapping(qualifiedByName = "brandWithoutProducts")
    List<Brand> toBrands(List<BrandEntity> brandEntities);

    @Mapping(target = "page", source = "number")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalPages", source = "totalPages")
    @Mapping(target = "count", source = "numberOfElements")
    @Mapping(target = "totalCount", source = "totalElements")
    @Mapping(target = "content", source = "content")
    DomainPage<Brand> toDomainPage(Page<BrandEntity> brandEntities);
}
