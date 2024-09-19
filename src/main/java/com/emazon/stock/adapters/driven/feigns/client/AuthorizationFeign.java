package com.emazon.stock.adapters.driven.feigns.client;

import com.emazon.stock.adapters.driven.feigns.dto.request.AuthorizationRequest;
import com.emazon.stock.adapters.driven.feigns.dto.response.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-MICROSERVICE", url = "${emazon.user.base-url}", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface AuthorizationFeign {

    @PostMapping(value = "/auth/authorize", consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthorizationResponse authorize(@RequestBody AuthorizationRequest authorizationRequest);
}
