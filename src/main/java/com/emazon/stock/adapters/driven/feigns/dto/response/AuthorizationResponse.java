package com.emazon.stock.adapters.driven.feigns.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationResponse {
    private boolean authorized;
}
