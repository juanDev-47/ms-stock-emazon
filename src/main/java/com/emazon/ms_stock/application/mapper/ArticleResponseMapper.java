package com.emazon.ms_stock.application.mapper;

import com.emazon.ms_stock.application.dto.ArticleResponse;
import com.emazon.ms_stock.application.dto.BrandDTO;
import com.emazon.ms_stock.domain.model.Article;
import com.emazon.ms_stock.domain.model.Brand;
import com.emazon.ms_stock.domain.model.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {CategoryDTOMapper.class, BrandDTO.class})
public interface ArticleResponseMapper {

    BrandDTOMapper INSTANCE1 = Mappers.getMapper(BrandDTOMapper.class);
//    CategoryDTOMapper INSTANCE2 = Mappers.getMapper(CategoryDTOMapper.class);


    ArticleResponse toDto(Article article);

    @InheritInverseConfiguration
    Article toEntity(ArticleResponse dto);

    default List<ArticleResponse> toDTOList(List<Article> articles, List<Category> categories, List<Brand> brands){
        return articles.stream()
                .map(article -> {
                    ArticleResponse articleResponse = new ArticleResponse();
                    articleResponse.setId(article.getId());
                    articleResponse.setName(article.getName());
                    articleResponse.setDescription(article.getDescription());
                    articleResponse.setAmount(article.getAmount());
                    articleResponse.setPrice(article.getPrice());
                    articleResponse.setBrand(INSTANCE1.toDto(brands.stream().filter(brand -> brand.getId().equals(article.getId_brand())).findFirst().orElse(null)));
//                    articleResponse.setCategory(INSTANCE2.toDto(categories.stream().filter(category -> category.getId().equals(article.getCategory().getId())).findFirst().orElse(null)));
                    return articleResponse;
                }).toList();
    };


}
