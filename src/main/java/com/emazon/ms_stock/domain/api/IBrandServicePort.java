package com.emazon.ms_stock.domain.api;

import com.emazon.ms_stock.domain.model.Brand;

import java.util.List;

public interface IBrandServicePort {
    Brand saveBrand(Brand brand);
    List<Brand> getAllBrand();
    Brand getBrand(Long id);
    void updateBrand(Brand brand);
    void deleteBrand(Long id);
}
