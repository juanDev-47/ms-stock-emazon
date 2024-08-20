package com.emazon.ms_stock.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ArticleResponse {
    private Long id;
    private Integer amount;
    private BigDecimal price;
    private BrandDTO brand;
    private CategoryDTO category;
}
