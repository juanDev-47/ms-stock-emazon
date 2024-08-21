package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper;

import com.emazon.ms_stock.domain.model.Article;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticleEntityMapper {
    ArticleEntity toEntity(Article article);
    Article toArticle(ArticleEntity articleEntity);
    List<Article> toArticleList(List<ArticleEntity> articlesEntityList);


}
