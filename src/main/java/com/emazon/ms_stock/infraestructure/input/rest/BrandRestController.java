package com.emazon.ms_stock.infraestructure.input.rest;

import com.emazon.ms_stock.application.dto.ArticleRequest;
import com.emazon.ms_stock.application.dto.BrandDTO;
import com.emazon.ms_stock.application.handler.IBrandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand/")
@RequiredArgsConstructor
public class BrandRestController {
    private final IBrandHandler brandHandler;

    @PostMapping
    public ResponseEntity<Void> saveBrand(@RequestBody BrandDTO brand){
        brandHandler.saveBrand(brand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
