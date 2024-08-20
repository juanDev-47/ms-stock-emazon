package com.emazon.ms_stock.application.mapper;

import com.emazon.ms_stock.application.dto.ArticleRequest;
import com.emazon.ms_stock.domain.model.Article;
import com.emazon.ms_stock.domain.model.Brand;
import com.emazon.ms_stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticleRequestMapper {
    Article toArticle(ArticleRequest articleRequest);

    Brand toBrand(ArticleRequest articleRequest);

    Category toCategory(ArticleRequest articleRequest);

}
