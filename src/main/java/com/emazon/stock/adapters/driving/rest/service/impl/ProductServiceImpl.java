package com.emazon.stock.adapters.driving.rest.service.impl;

import com.emazon.stock.adapters.driving.rest.dto.request.PaginationRequest;
import com.emazon.stock.adapters.driving.rest.dto.request.ProductRequest;
import com.emazon.stock.adapters.driving.rest.dto.response.PageResponse;
import com.emazon.stock.adapters.driving.rest.dto.response.ProductResponse;
import com.emazon.stock.adapters.driving.rest.mapper.request.PaginationRequestMapper;
import com.emazon.stock.adapters.driving.rest.mapper.request.ProductRequestMapper;
import com.emazon.stock.adapters.driving.rest.mapper.response.ProductResponseMapper;
import com.emazon.stock.adapters.driving.rest.service.ProductService;
import com.emazon.stock.domain.api.ProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductServicePort productServicePort;
    private final ProductRequestMapper productRequestMapper;
    private final ProductResponseMapper productResponseMapper;
    private final PaginationRequestMapper paginationRequestMapper;


    @Override
    public void save(ProductRequest product) {
        productServicePort.save(productRequestMapper.toProduct(product));
    }

    @Override
    public PageResponse<ProductResponse> getAllProducts(PaginationRequest paginationRequest) {
        return productResponseMapper.toPageResponse(productServicePort.getAllProducts(paginationRequestMapper.toPaginationData(paginationRequest)));
    }
}
