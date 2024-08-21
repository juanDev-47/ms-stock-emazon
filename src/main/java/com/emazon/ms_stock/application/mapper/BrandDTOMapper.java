package com.emazon.ms_stock.application.mapper;

import com.emazon.ms_stock.application.dto.BrandDTO;
import com.emazon.ms_stock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandDTOMapper {
    BrandDTO toDto(Brand brand);
    List<BrandDTO> toDtoList(List<Brand> brands);
    Brand toEntity(BrandDTO dto);


}
