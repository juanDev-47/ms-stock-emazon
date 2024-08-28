package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.model.Product;
import com.emazon.stock.domain.utils.pagination.DomainPage;
import com.emazon.stock.domain.utils.pagination.PaginationData;

import java.util.List;

public interface ProductPersistencePort {
    void save(Product product);
    DomainPage<Product> getAllProducts(PaginationData paginationData);
    List<Category> getProductCategories(Long id);
}
