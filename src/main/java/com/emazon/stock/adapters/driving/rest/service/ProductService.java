package com.emazon.stock.adapters.driving.rest.service;

import com.emazon.stock.adapters.driving.rest.dto.request.PaginationRequest;
import com.emazon.stock.adapters.driving.rest.dto.request.ProductRequest;
import com.emazon.stock.adapters.driving.rest.dto.response.PageResponse;
import com.emazon.stock.adapters.driving.rest.dto.response.ProductResponse;


public interface ProductService {
    void save(ProductRequest product);
    PageResponse<ProductResponse> getAllProducts(PaginationRequest paginationRequest);
//    List<CategoryResponse> getProductCategories(Long id);
}
