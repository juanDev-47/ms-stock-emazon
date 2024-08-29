package com.emazon.stock.adapters.driving.rest.dto.response;

import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    //Attributes
    private Long id;
    private String name;
    private String description;
}
