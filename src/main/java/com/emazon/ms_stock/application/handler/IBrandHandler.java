package com.emazon.ms_stock.application.handler;


import com.emazon.ms_stock.application.dto.BrandDTO;

import java.util.List;

public interface IBrandHandler {
    void saveBrand(BrandDTO brand);
    List<BrandDTO> getAllBrand(Integer page, Integer size, String order);
    BrandDTO getArticle(Long id);
    void updateArticle(BrandDTO brand);
    void deleteArticle(Long id);
}
