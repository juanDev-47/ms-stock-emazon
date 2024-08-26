package com.emazon.ms_stock.infraestructure.input.rest;

import com.emazon.ms_stock.application.dto.BrandDTO;
import com.emazon.ms_stock.application.handler.IBrandHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand/")
@RequiredArgsConstructor
public class BrandRestController {
    private final IBrandHandler brandHandler;

    @PostMapping
    public ResponseEntity<Void> saveBrand(@Valid @RequestBody BrandDTO brand){
        brandHandler.saveBrand(brand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getBrands(){
        return ResponseEntity.ok(brandHandler.getAllArticle());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id){
        brandHandler.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }


}
