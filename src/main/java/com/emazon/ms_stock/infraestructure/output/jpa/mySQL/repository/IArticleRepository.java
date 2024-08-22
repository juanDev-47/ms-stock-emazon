package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository;

import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {


}
