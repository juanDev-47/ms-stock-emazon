package com.emazon.stock.adapters.driving.rest.dto.request;

import com.emazon.stock.domain.utils.DomainConstants;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSuppliesRequestDTO {
    @NotNull(message = DomainConstants.FIELD_ID_NULL_MESSAGE)
    private Long productId;

    @NotNull(message = DomainConstants.FIELD_ID_NULL_MESSAGE)
    @Min(value = 0L, message = "The value must be positive")
    private Long amountProduct;
}
