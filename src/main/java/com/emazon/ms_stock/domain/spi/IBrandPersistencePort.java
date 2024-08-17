package com.emazon.ms_stock.domain.spi;

import com.emazon.ms_stock.domain.model.Brand;

import java.util.List;

public interface IBrandPersistencePort {
    void saveBrand(Brand brand);
    List<Brand> getAllBrand();
    Brand getBrand(Long id);
    void updateBrand(Brand brand);
    void deleteBrand(Long id);
}
