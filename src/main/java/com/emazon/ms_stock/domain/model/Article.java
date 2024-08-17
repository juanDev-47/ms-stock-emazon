package com.emazon.ms_stock.domain.model;

import java.math.BigDecimal;

public class Article {

    private Long id;
    private Integer amount;
    private BigDecimal price;
    private Long id_category;
    private Long id_brand;

    public Article(Long id, Integer amount, BigDecimal price, Long id_category, Long id_brand) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.id_category = id_category;
        this.id_brand = id_brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public Long getId_brand() {
        return id_brand;
    }

    public void setId_brand(Long id_brand) {
        this.id_brand = id_brand;
    }
}
