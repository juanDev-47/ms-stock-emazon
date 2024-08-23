package com.emazon.ms_stock.infraestructure.input.rest;

import com.emazon.ms_stock.application.dto.CategoryDTO;
import com.emazon.ms_stock.application.handler.ICategoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/")
@RequiredArgsConstructor
public class CategoryRestController {
    private final ICategoryHandler categoryHandler;

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CategoryDTO category) {
        categoryHandler.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        return ResponseEntity.ok(categoryHandler.getAllCategories());
    }

    @PutMapping
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryDTO category){
        categoryHandler.updateCategory(category);
        return ResponseEntity.noContent().build();
    }

}
