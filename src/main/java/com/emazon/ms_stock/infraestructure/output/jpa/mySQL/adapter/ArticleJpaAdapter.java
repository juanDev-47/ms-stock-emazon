package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.adapter;

import com.emazon.ms_stock.domain.model.Article;
import com.emazon.ms_stock.domain.spi.IArticlePersistencePort;
import com.emazon.ms_stock.infraestructure.exception.ArticleAlreadyExistException;
import com.emazon.ms_stock.infraestructure.exception.ArticleNotFoundException;
import com.emazon.ms_stock.infraestructure.exception.BrandAlreadyExistException;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.ArticleEntity;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper.ArticleEntityMapper;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository.IArticleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ArticleJpaAdapter implements IArticlePersistencePort {
    private final ArticleEntityMapper articleEntityMapper;
    private final IArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article article) {
        if(articleRepository.findArticleEntitiesByName(article.getName()).isPresent()){
            throw new ArticleAlreadyExistException();
        }
        return articleEntityMapper.toArticle(articleRepository.save(articleEntityMapper.toEntity(article)));
    }

    @Override
    public List<Article> getAllArticle() {
        List<ArticleEntity> articleEntities = articleRepository.findAll();
        if(articleEntities.isEmpty()){
            throw new ArticleNotFoundException();
        }
        return articleEntityMapper.toArticleList(articleEntities);
    }

    @Override
    public Article getArticle(Long id) {
        return articleEntityMapper.toArticle(articleRepository.findById(id).orElseThrow(ArticleNotFoundException::new));
    }

    @Override
    public void updateArticle(Article article) {
        articleRepository.save(articleEntityMapper.toEntity(article));
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
