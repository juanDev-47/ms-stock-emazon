package com.emazon.ms_stock.domain.spi;

import com.emazon.ms_stock.domain.model.Article;

import java.util.List;

public interface IArticlePersistencePort {
    void saveArticle(Article article);
    List<Article> getAllArticle();
    Article getArticle(Long id);
    void updateArticle(Article article);
    void deleteArticle(Long id);
}
