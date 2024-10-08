package com.emazon.stock.domain.api;

import com.emazon.stock.domain.dto.request.AddSuppliesDTO;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.model.Product;
import com.emazon.stock.domain.utils.pagination.DomainPage;
import com.emazon.stock.domain.utils.pagination.PaginationData;

import java.util.List;

public interface ProductServicePort {
    void save(Product product);
    DomainPage<Product> getAllProducts(PaginationData paginationData);

    void addSupplies(AddSuppliesDTO addSuppliesDTO);

}
