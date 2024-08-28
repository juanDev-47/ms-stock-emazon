package com.emazon.stock.adapters.driven.jpa.adapter;

import com.emazon.stock.adapters.driven.jpa.entity.BrandEntity;
import com.emazon.stock.adapters.driven.jpa.entity.CategoryEntity;
import com.emazon.stock.adapters.driven.jpa.entity.ProductEntity;
import com.emazon.stock.adapters.driven.jpa.mapper.PaginationJPAMapper;
import com.emazon.stock.adapters.driven.jpa.mapper.ProductEntityMapper;
import com.emazon.stock.adapters.driven.jpa.persistence.ProductRepository;
import com.emazon.stock.adapters.driven.jpa.utils.PaginationJPA;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.model.Product;
import com.emazon.stock.domain.utils.pagination.DomainPage;
import com.emazon.stock.domain.utils.pagination.PaginationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductJpaAdapterTest {


    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductEntityMapper productEntityMapper;

    @Mock
    private PaginationJPAMapper paginationJPAMapper;

    @InjectMocks
    private ProductJpaAdapter productJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        Product product = new Product(null, "burger", "a burger", BigDecimal.valueOf(0), 1L, Collections.singletonList(new Category()), new Brand());
        ProductEntity productEntity = new ProductEntity(null, "burger", "a burger", BigDecimal.valueOf(0), 1L, Collections.singleton(new CategoryEntity()), new BrandEntity());
        when(productEntityMapper.toEntity(product)).thenReturn(productEntity);
        productJpaAdapter.save(product);
        verify(productRepository).save(productEntity);
    }

    @Test
    void getAllProducts() {
        PaginationData paginationData = new PaginationData(0, null, false);
        PaginationJPA paginationJPA = new PaginationJPA(0, null, true);
        Page<ProductEntity> productEntities = new PageImpl<>(List.of(
                new ProductEntity(1L, "burger", "a burger", BigDecimal.valueOf(0), 1L, Collections.singleton(new CategoryEntity()), new BrandEntity()),
                new ProductEntity(2L, "burger2", "another burger", BigDecimal.valueOf(0), 1L, Collections.singleton(new CategoryEntity()), new BrandEntity())
        ));
        DomainPage<Product> mockProducts = new DomainPage<>();
        mockProducts.setContent(List.of(
                new Product(1L, "burger", "a burger", BigDecimal.valueOf(0), 1L, Collections.singletonList(new Category()), new Brand()),
                new Product(2L, "burger2", "another burger", BigDecimal.valueOf(0), 1L, Collections.singletonList(new Category()), new Brand())
        ));
        when(productRepository.findAll(any(Pageable.class))).thenReturn(productEntities);
        when(productEntityMapper.toDomainPage(any())).thenReturn(mockProducts);
        when(paginationJPAMapper.toJPA(paginationData)).thenReturn(paginationJPA);
        DomainPage<Product> returnedProducts = productJpaAdapter.getAllProducts(paginationData);
        assertEquals(mockProducts.getContent().get(0).getName(), returnedProducts.getContent().get(0).getName());
        assertEquals(mockProducts.getContent().get(1).getName(), returnedProducts.getContent().get(1).getName());
    }

    @Test
    void getProductCategories() {
        // TODO: UH6
    }
}