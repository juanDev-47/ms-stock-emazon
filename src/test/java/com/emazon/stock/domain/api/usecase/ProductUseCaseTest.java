package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.exceptions.*;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.model.Product;
import com.emazon.stock.domain.spi.BrandPersistencePort;
import com.emazon.stock.domain.spi.CategoryPersistencePort;
import com.emazon.stock.domain.spi.ProductPersistencePort;
import com.emazon.stock.domain.utils.pagination.DomainPage;
import com.emazon.stock.domain.utils.pagination.PaginationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ProductUseCaseTest {

    @Mock
    private ProductPersistencePort productPersistencePort;

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @Mock
    private BrandPersistencePort brandPersistencePort;

    @InjectMocks
    ProductUseCase productUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        Category mockCategory = new Category(1L, "nothing", "nothing", null);
        Brand mockBrand = new Brand(1L, "nothing", "nothing", null);
        Product mockProduct = new Product(1L, "burger", "a burger", BigDecimal.valueOf(0), 1L, Collections.singletonList(mockCategory),  mockBrand);
        when(brandPersistencePort.getBrand( mockBrand.getId())).thenReturn( mockBrand);
        when(categoryPersistencePort.getCategory(mockCategory.getId())).thenReturn(mockCategory);
        productUseCase.save(mockProduct);
        verify(productPersistencePort).save(mockProduct);
    }

    @Test
    void saveNullPrice(){
        Category mockCategory = new Category(1L, "nothing", "nothing", null);
        Brand mockBrand = new Brand(1L, "nothing", "nothing", null);
        Product mockProduct = new Product(1L, "burger", "a burger", null, 1L, Collections.singletonList(mockCategory),  mockBrand);
        assertThrows(EmptyFieldException.class, ()-> productUseCase.save(mockProduct));
        verify(productPersistencePort, times(0)).save(mockProduct);
    }

    @Test
    void saveNullQuantity(){
        Category mockCategory = new Category(1L, "nothing", "nothing", null);
        Brand mockBrand = new Brand(1L, "nothing", "nothing", null);
        Product mockProduct = new Product(1L, "burger", "a burger", BigDecimal.valueOf(0), null, Collections.singletonList(mockCategory),  mockBrand);
        assertThrows(EmptyFieldException.class, ()-> productUseCase.save(mockProduct));
        verify(productPersistencePort, times(0)).save(mockProduct);
    }

    @Test
    void saveNegativePrice(){
        Category mockCategory = new Category(1L, "nothing", "nothing", null);
        Brand mockBrand = new Brand(1L, "nothing", "nothing", null);
        Product mockProduct = new Product(1L, "burger", "a burger", BigDecimal.valueOf(-2), 1L, Collections.singletonList(mockCategory),  mockBrand);
        assertThrows(NegativeNotAllowedException.class, ()-> productUseCase.save(mockProduct));
        verify(productPersistencePort, times(0)).save(mockProduct);
    }

    @Test
    void saveNegativeQuantity(){
        Category mockCategory = new Category(1L, "nothing", "nothing", null);
        Brand mockBrand = new Brand(1L, "nothing", "nothing", null);
        Product mockProduct = new Product(1L, "burger", "a burger", BigDecimal.valueOf(2), -1L, Collections.singletonList(mockCategory),  mockBrand);
        assertThrows(NegativeNotAllowedException.class, ()-> productUseCase.save(mockProduct));
        verify(productPersistencePort, times(0)).save(mockProduct);
    }

    @Test
    void saveNullBrand(){
        Category mockCategory = new Category(1L, "nothing", "nothing", null);
        Product mockProduct = new Product(1L, "burger", "a burger", BigDecimal.valueOf(2), 1L, Collections.singletonList(mockCategory),  null);
        assertThrows(EmptyFieldException.class, ()-> productUseCase.save(mockProduct));
        verify(productPersistencePort, times(0)).save(mockProduct);
    }

    @Test
    void saveNoCategory(){
        Brand mockBrand = new Brand(1L, "nothing", "nothing", null);
        Product mockProduct = new Product(1L, "burger", "a burger", BigDecimal.valueOf(2), 1L, Collections.emptyList(),  mockBrand);
        Product mockProduct1 = new Product(1L, "burger", "a burger", BigDecimal.valueOf(2), 1L, null,  mockBrand);
        assertThrows(NotEnoughCategoriesException.class, ()-> productUseCase.save(mockProduct));
        assertThrows(NotEnoughCategoriesException.class, ()-> productUseCase.save(mockProduct1));

        verify(productPersistencePort, times(0)).save(mockProduct);
    }

    @Test
    void saveDuplicateCategories(){
        Category mockCategory = new Category(1L, "nothing", "nothing", null);
        Brand mockBrand = new Brand(1L, "nothing", "nothing", null);
        Product mockProduct = new Product(1L, "burger", "a burger", BigDecimal.valueOf(0), 1L, List.of(mockCategory,mockCategory),  mockBrand);
        assertThrows(DuplicatedProductCategoryException.class, ()-> productUseCase.save(mockProduct));
        verify(productPersistencePort, times(0)).save(mockProduct);
    }

    @Test
    void saveTooMuchCategories(){
        List<Category> mockCategories = List.of(
                new Category(1L, "nothing", "nothing", null),
                 new Category(2L, "nothing1", "nothing", null),
                new Category(3L, "nothing3", "nothing", null),
                 new Category(4L, "nothing4", "nothing", null)
        );
        Brand mockBrand = new Brand(1L, "nothing", "nothing", null);
        Product mockProduct = new Product(1L, "burger", "a burger", BigDecimal.valueOf(0), 1L, mockCategories,  mockBrand);
        assertThrows(OutOfBoundsException.class, ()-> productUseCase.save(mockProduct));
        verify(productPersistencePort, times(0)).save(mockProduct);
    }

    @Test
    void getAllProducts() {
        PaginationData paginationData = new PaginationData(0, null, true);
        DomainPage<Product> mockProducts = new DomainPage<>();
        mockProducts.setContent(List.of(
                new Product(1L, "burger", "a burger", BigDecimal.valueOf(0), 1L, Collections.singletonList(new Category()), new Brand()),
                new Product(2L, "burger2", "another burger", BigDecimal.valueOf(0), 1L, Collections.singletonList(new Category()), new Brand())
        ));
        when(productPersistencePort.getAllProducts(paginationData)).thenReturn(mockProducts);
        DomainPage<Product> products = productUseCase.getAllProducts(paginationData);

        verify(productPersistencePort).getAllProducts(paginationData);
        assertEquals(mockProducts.getContent().size(), products.getContent().size());
        assertEquals(mockProducts.getContent().get(0).getId(), products.getContent().get(0).getId());
        assertEquals(mockProducts.getContent().get(1).getId(), products.getContent().get(1).getId());
    }

    @Test
    void getProductCategories() {
    }
}