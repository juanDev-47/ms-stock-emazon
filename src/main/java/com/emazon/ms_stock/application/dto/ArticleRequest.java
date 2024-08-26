package com.emazon.ms_stock.application.dto;

import com.emazon.ms_stock.domain.model.Brand;
import com.emazon.ms_stock.domain.model.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
public class ArticleRequest {
    private Long id;
    @NotBlank(message = "Name cant be empty")
    private String name;
    @NotBlank(message = "description cant be empty")
    private String description;
    private Integer amount;
    private BigDecimal price;
    private Category category;
    private Brand brand;
}
