package com.emazon.ms_stock.infraestructure.input.rest;

import com.emazon.ms_stock.application.dto.BrandDTO;
import com.emazon.ms_stock.application.dto.CategoryDTO;
import com.emazon.ms_stock.application.handler.IBrandHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand/")
@RequiredArgsConstructor
@Tag(name = "Brand Management", description = "API for management brand in stock ms")
public class BrandRestController {
    private final IBrandHandler brandHandler;

    @Operation(summary = "Create new brand",
            description = "Create new brand with data delivered")
    @ApiResponse(responseCode = "200", description = "Brand successes created",
            content = @Content(schema = @Schema(implementation = BrandDTO.class)))
    @ApiResponse(responseCode = "400", description = "Data invalid")
    @PostMapping
    public ResponseEntity<Void> saveBrand(@Valid @RequestBody BrandDTO brand){
        brandHandler.saveBrand(brand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getBrands(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "3") Integer size, @RequestParam(required = false, defaultValue = "asc") String order){
        return ResponseEntity.ok(brandHandler.getAllBrand(page, size, order));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id){
        brandHandler.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }


}
