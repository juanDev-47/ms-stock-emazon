package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.adapter;

import com.emazon.ms_stock.domain.model.Brand;
import com.emazon.ms_stock.domain.spi.IBrandPersistencePort;
import com.emazon.ms_stock.infraestructure.exception.BrandAlreadyExistException;
import com.emazon.ms_stock.infraestructure.exception.BrandNotFoundException;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.BrandEntity;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper.BrandEntityMapper;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BrandJpaAdapter implements IBrandPersistencePort{
    private final BrandEntityMapper brandEntityMapper;
    private final IBrandRepository brandRepository;

    @Override
    public void saveBrand(Brand brand) {
        if(brandRepository.findBrandEntitiesByName(brand.getName()).isPresent()){
            throw new BrandAlreadyExistException();
        }
        brandRepository.save(brandEntityMapper.toBrandEntity(brand));
    }

    @Override
    public List<Brand> getAllBrand() {
        List<BrandEntity> brands = brandRepository.findAll();
        if(brands.isEmpty()){
            throw new BrandNotFoundException();
        }
        return brandEntityMapper.toBrandList(brands);
    }

    @Override
    public Brand getBrand(Long id) {
        return brandEntityMapper.toBrand(brandRepository.findById(id).orElseThrow(BrandNotFoundException::new));
    }

    @Override
    public void updateBrand(Brand brand) {
        brandRepository.save(brandEntityMapper.toBrandEntity(brand));
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
