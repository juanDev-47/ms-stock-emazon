package com.emazon.ms_stock.domain.useCase;

import com.emazon.ms_stock.domain.api.IArticleServicePort;
import com.emazon.ms_stock.domain.model.Article;
import com.emazon.ms_stock.domain.spi.IArticlePersistencePort;

import java.util.List;
import java.util.Optional;

public class ArticleUseCase implements IArticleServicePort {

    private final IArticlePersistencePort articlePersistencePort;

    public ArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }

    @Override
    public Article saveArticle(Article article) {
        return articlePersistencePort.saveArticle(article);
    }

    @Override
    public List<Article> getAllArticle() {
        return articlePersistencePort.getAllArticle();
    }

    @Override
    public Article getArticle(Long id) {
        return articlePersistencePort.getArticle(id);
    }

    @Override
    public void updateArticle(Article article) {
        articlePersistencePort.updateArticle(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articlePersistencePort.deleteArticle(id);
    }
}
