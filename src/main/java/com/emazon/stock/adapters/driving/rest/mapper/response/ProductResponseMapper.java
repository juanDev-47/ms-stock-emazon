package com.emazon.stock.adapters.driving.rest.mapper.response;


import com.emazon.stock.adapters.driving.rest.dto.response.PageResponse;
import com.emazon.stock.adapters.driving.rest.dto.response.ProductResponse;
import com.emazon.stock.domain.model.Product;
import com.emazon.stock.domain.utils.pagination.DomainPage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductResponseMapper {
    ProductResponse toResponse(Product product);

    List<ProductResponse> toList(List<Product> products);


    PageResponse<ProductResponse> toPageResponse(DomainPage<Product> products);
}
