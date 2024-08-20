package com.emazon.ms_stock.application.mapper;

import com.emazon.ms_stock.application.dto.ArticleResponse;
import com.emazon.ms_stock.application.dto.BrandDTO;
import com.emazon.ms_stock.domain.model.Article;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {CategoryDTOMapper.class, BrandDTO.class})
public interface ArticleResponseMapper {
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "category", source = "category")
    ArticleResponse toDto(Article article);

    @InheritInverseConfiguration
    Article toEntity(ArticleResponse dto);

    List<ArticleResponse> toDTOList(List<Article> articles);


}
