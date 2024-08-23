package com.emazon.ms_stock.application.dto;

import com.emazon.ms_stock.domain.model.Brand;
import com.emazon.ms_stock.domain.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
public class ArticleRequest {
    private Long id;
    private String name;
    private String description;
    private Integer amount;
    private BigDecimal price;
    private Category category;
    private Brand brand;
}
