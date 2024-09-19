package com.emazon.stock.adapters.driven.jpa.adapter;

import com.emazon.stock.adapters.driven.jpa.entity.ProductEntity;
import com.emazon.stock.adapters.driven.jpa.mapper.ProductEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mapper.PaginationJPAMapper;
import com.emazon.stock.adapters.driven.jpa.persistence.ProductRepository;
import com.emazon.stock.domain.dto.request.AddSuppliesDTO;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.model.Product;
import com.emazon.stock.domain.spi.ProductPersistencePort;
import com.emazon.stock.domain.utils.pagination.DomainPage;
import com.emazon.stock.domain.utils.pagination.PaginationData;
import io.swagger.v3.core.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductJpaAdapter implements ProductPersistencePort {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;
    private final PaginationJPAMapper paginationJPAMapper;

    @Override
    public void save(Product product) {
        productRepository.save(productEntityMapper.toEntity(product));
    }

    @Override
    public DomainPage<Product> getAllProducts(PaginationData paginationData) {
        Pageable pageable = paginationJPAMapper.toJPA(paginationData).createPageable();
        Page<ProductEntity> returnProducts = productRepository.findAll(pageable);
        return productEntityMapper.toDomainPage(returnProducts);
    }

    @Override
    public void addSupplies(AddSuppliesDTO addSuppliesDTO) {
        Optional<ProductEntity> product = productRepository.findById(addSuppliesDTO.getProductId());

        product.ifPresent(productEntity -> {
            productEntity.setQuantity( ( productEntity.getQuantity() + addSuppliesDTO.getAmountProduct() ) );
            productRepository.save(productEntity);
        });
    }

}
