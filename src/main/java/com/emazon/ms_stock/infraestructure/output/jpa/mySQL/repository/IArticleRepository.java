package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository;

import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.ArticleEntity;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {

    Optional<ArticleEntity> findArticleEntitiesByName(String name);

}
