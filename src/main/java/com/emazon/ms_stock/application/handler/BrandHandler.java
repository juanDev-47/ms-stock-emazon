package com.emazon.ms_stock.application.handler;

import com.emazon.ms_stock.application.dto.BrandDTO;
import com.emazon.ms_stock.application.mapper.BrandDTOMapper;
import com.emazon.ms_stock.domain.api.IBrandServicePort;
import com.emazon.ms_stock.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandHandler implements IBrandHandler{
    private final IBrandServicePort brandServicePort;
    private final BrandDTOMapper brandDTOMapper;

    @Override
    public void saveBrand(BrandDTO brand) {
        brandServicePort.saveBrand(brandDTOMapper.toEntity(brand));
    }

    @Override
    public List<BrandDTO> getAllArticle() {
        List<Brand> brands = brandServicePort.getAllBrand();
        return brandDTOMapper.toDtoList(brands);
    }

    @Override
    public BrandDTO getArticle(Long id) {
        Brand brand = brandServicePort.getBrand(id);
        return brandDTOMapper.toDto(brand);
    }

    @Override
    public void updateArticle(BrandDTO brand) {
        Brand oldBrand = brandServicePort.getBrand(brand.getId());
        Brand newBrand = brandDTOMapper.toEntity(brand);
        newBrand.setId(oldBrand.getId());
        brandServicePort.updateBrand(newBrand);
    }

    @Override
    public void deleteArticle(Long id) {
        Brand brand = brandServicePort.getBrand(id);
        brandServicePort.deleteBrand(brand.getId());
    }
}
