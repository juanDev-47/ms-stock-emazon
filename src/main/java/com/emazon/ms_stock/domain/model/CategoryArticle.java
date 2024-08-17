package com.emazon.ms_stock.domain.model;

public class CategoryArticle {
    private Long id_category;
    private Long id_article;

    public CategoryArticle(Long id_category, Long id_article) {
        this.id_category = id_category;
        this.id_article = id_article;
    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public Long getId_article() {
        return id_article;
    }

    public void setId_article(Long id_article) {
        this.id_article = id_article;
    }
}
