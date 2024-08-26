package com.emazon.ms_stock.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Long id;

    @NotBlank(message = "Name cant be empty")
    @Size(min = 3, max = 50, message = "Name cant be less than 3 more extensive from 50")
    private String name;

    @Size(min = 3, max = 90, message = "Description cant be less than 3 more extensive from 90")
    @NotBlank(message = "Description cant be empty")
    private String description;
}
