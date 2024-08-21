package com.emazon.ms_stock.application.handler;

import com.emazon.ms_stock.application.dto.ArticleRequest;
import com.emazon.ms_stock.application.dto.ArticleResponse;
import com.emazon.ms_stock.application.mapper.ArticleRequestMapper;
import com.emazon.ms_stock.application.mapper.ArticleResponseMapper;
import com.emazon.ms_stock.application.mapper.CategoryDTOMapper;
import com.emazon.ms_stock.domain.api.IArticleServicePort;
import com.emazon.ms_stock.domain.api.IBrandServicePort;
import com.emazon.ms_stock.domain.api.ICategoryServicePort;
import com.emazon.ms_stock.domain.model.Article;
import com.emazon.ms_stock.domain.model.Brand;
import com.emazon.ms_stock.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleHandler implements IArticleHandler {

    private final IArticleServicePort articleServicePort;
    private final IBrandServicePort brandServicePort;
    private final ICategoryServicePort categoryServicePort;
    private final CategoryDTOMapper categoryDTOMapper;
    private final ArticleResponseMapper articleResponseMapper;
    private final ArticleRequestMapper articleRequestMapper;

    @Override
    public void saveArticle(ArticleRequest articleRequest) {
        Brand brand = brandServicePort.saveBrand(articleRequestMapper.toBrand(articleRequest));
        Category category = categoryServicePort.saveCategory(articleRequestMapper.toCategory(articleRequest));
        Article article = articleRequestMapper.toArticle(articleRequest);
        article.setId_brand(brand.getId());
        article.setId_category(category.getId());
        articleServicePort.saveArticle(article);

    }

    @Override
    public List<ArticleResponse> getAllArticle() {
        List<Article> articles = articleServicePort.getAllArticle();
        return articleResponseMapper.toDTOList(articles);
    }

    @Override
    public ArticleResponse getArticle(Long id) {
        Article article = articleServicePort.getArticle(id);
        return articleResponseMapper.toDto(article);
    }

    @Override
    public void updateArticle(ArticleRequest article) {
        Article oldArticle = articleServicePort.getArticle(article.getId());
        Brand newBrand = articleRequestMapper.toBrand(article);
        newBrand.setId(oldArticle.getId_brand());
        brandServicePort.updateBrand(newBrand);
        Category newCategory = articleRequestMapper.toCategory(article);
        newCategory.setId(oldArticle.getId_category());
        categoryServicePort.updateCategory(newCategory);
        Article newArticle = articleRequestMapper.toArticle(article);
        newArticle.setId(oldArticle.getId());
        newArticle.setId_category(oldArticle.getId_category());
        newArticle.setId_brand(oldArticle.getId_brand());
        articleServicePort.updateArticle(newArticle);

    }

    @Override
    public void deleteArticle(Long id) {
        Article article = articleServicePort.getArticle(id);
        brandServicePort.deleteBrand(article.getId_brand());
        categoryServicePort.deleteCategory(article.getId_category());
        articleServicePort.deleteArticle(id);
    }
}
