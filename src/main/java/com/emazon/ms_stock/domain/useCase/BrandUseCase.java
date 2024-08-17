package com.emazon.ms_stock.domain.useCase;

import com.emazon.ms_stock.domain.api.IBrandServicePort;
import com.emazon.ms_stock.domain.model.Brand;

import java.util.List;

public class BrandUseCase implements IBrandServicePort {

    private final IBrandServicePort brandServicePort;

    public BrandUseCase(IBrandServicePort brandServicePort){
        this.brandServicePort = brandServicePort;
    }
    @Override
    public void saveBrand(Brand brand) {
        brandServicePort.saveBrand(brand);
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandServicePort.getAllBrand();
    }

    @Override
    public Brand getBrand(Long id) {
        return brandServicePort.getBrand(id);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandServicePort.updateBrand(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        brandServicePort.deleteBrand(id);
    }
}
