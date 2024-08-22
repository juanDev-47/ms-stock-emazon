package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper;

import com.emazon.ms_stock.domain.model.Brand;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandEntityMapper {
    BrandEntity toBrandEntity(Brand brand);
    List<Brand> toBrandList(List<BrandEntity> brands);
    Brand toBrand(BrandEntity brandEntity);
}
