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
    private final ArticleResponseMapper articleResponseMapper;
    private final ArticleRequestMapper articleRequestMapper;


    @Override
    public void saveArticle(ArticleRequest articleRequest) {
        Article article = articleRequestMapper.toArticle(articleRequest);
        articleServicePort.saveArticle(article);

    }

    @Override
    public List<ArticleResponse> getAllArticle() {
        Integer page = 0;
        Integer size = 3;
        String order = "asc";
        return articleResponseMapper.toDTOList(articleServicePort.getAllArticle(), brandServicePort.getAllBrand(page, size, order));
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
        newBrand.setId(oldArticle.getBrand().getId());
        brandServicePort.updateBrand(newBrand);
        Category newCategory = articleRequestMapper.toCategory(article);
        newCategory.setId(oldArticle.getCategory().getId());
        categoryServicePort.updateCategory(newCategory);
        Article newArticle = articleRequestMapper.toArticle(article);
        newArticle.setId(oldArticle.getId());
        articleServicePort.updateArticle(newArticle);

    }

    @Override
    public void deleteArticle(Long id) {
        Article article = articleServicePort.getArticle(id);
        brandServicePort.deleteBrand(article.getBrand().getId());
        categoryServicePort.deleteCategory(article.getCategory().getId());
        articleServicePort.deleteArticle(id);
    }
}
