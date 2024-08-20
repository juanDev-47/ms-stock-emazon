package com.emazon.ms_stock.application.mapper;

import com.emazon.ms_stock.application.dto.BrandDTO;
import com.emazon.ms_stock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandDTOMapper {
    BrandDTO toDto(Brand brand);
    Brand toEntity(BrandDTO dto);
}
