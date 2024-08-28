package com.emazon.stock.adapters.driving.rest.mapper.request;


import com.emazon.stock.adapters.driving.rest.dto.request.PaginationRequest;
import com.emazon.stock.domain.utils.pagination.PaginationData;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaginationRequestMapper {
    PaginationData toPaginationData(PaginationRequest paginationRequest);
}
