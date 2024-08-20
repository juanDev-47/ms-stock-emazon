package com.emazon.ms_stock.application.handler;

import com.emazon.ms_stock.application.dto.ArticleRequest;
import com.emazon.ms_stock.application.dto.ArticleResponse;

import java.util.List;

public interface IArticleHandler {
    void saveArticle(ArticleRequest article);
    List<ArticleResponse> getAllArticle();
    ArticleResponse getArticle(Long id);
    void updateArticle(ArticleRequest article);
    void deleteArticle(Long id);
}
