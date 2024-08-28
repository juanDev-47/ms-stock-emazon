package com.emazon.stock.adapters.driving.rest.dto.request;

import com.emazon.stock.domain.utils.DomainConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    @NotNull(message = DomainConstants.FIELD_NAME_NULL_MESSAGE)
    @Size(max=50, message = "Name must be shorter than 50 chars")
    private String name;

    @NotNull(message = DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE)
    @Size(max=90, message = "Description must be shorter than 90 chars")
    private String description;
}
