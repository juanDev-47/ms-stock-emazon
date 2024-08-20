package com.emazon.ms_stock.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
public class ArticleRequest {
    private Long id;
    private Integer amount;
    private BigDecimal price;
    private Long id_category;
    private Long id_brand;
}
