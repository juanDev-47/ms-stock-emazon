package com.emazon.ms_stock.domain.model;

import java.math.BigDecimal;

public class Article {

    private Long id;
    private String name;
    private String description;
    private Integer amount;
    private BigDecimal price;
    private Long id_brand;
    private Brand brand;
    private Category category;

    public Article(Long id, String name, String description, Integer amount, BigDecimal price, Long id_brand, Brand brand, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.id_brand = id_brand;
        this.brand = brand;
        this.category = category;
    }

    public Long getId_brand() {
        return id_brand;
    }

    public void setId_brand(Long id_brand) {
        this.id_brand = id_brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
