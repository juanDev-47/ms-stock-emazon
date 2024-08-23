package com.emazon.ms_stock.domain.useCase;

import com.emazon.ms_stock.domain.api.IBrandServicePort;
import com.emazon.ms_stock.domain.model.Brand;
import com.emazon.ms_stock.domain.spi.IBrandPersistencePort;

import java.util.List;

public class BrandUseCase implements IBrandServicePort {

    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort){
        this.brandPersistencePort = brandPersistencePort;
    }
    @Override
    public Brand saveBrand(Brand brand) {
        brandPersistencePort.saveBrand(brand);
        return brand;
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandPersistencePort.getAllBrand();
    }

    @Override
    public Brand getBrand(Long id) {
        return brandPersistencePort.getBrand(id);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandPersistencePort.updateBrand(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        brandPersistencePort.deleteBrand(id);
    }
}
