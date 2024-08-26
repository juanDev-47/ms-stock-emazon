package com.emazon.ms_stock.infraestructure.input.rest;

import com.emazon.ms_stock.application.dto.CategoryDTO;
import com.emazon.ms_stock.application.handler.ICategoryHandler;
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
@RequestMapping("/category/")
@RequiredArgsConstructor
@Tag(name = "Category Management", description = "API for management categories in stock ms")
public class CategoryRestController {
    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Create new category",
            description = "Create new category with data delivered")
    @ApiResponse(responseCode = "200", description = "Category successes created",
            content = @Content(schema = @Schema(implementation = CategoryDTO.class)))
    @ApiResponse(responseCode = "400", description = "Data invalid")
    @PostMapping
    public ResponseEntity<Void> createCategory(@Valid @RequestBody CategoryDTO category) {
        categoryHandler.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories(@RequestParam Integer page, @RequestParam(required = false, defaultValue = "3") Integer size, @RequestParam(required = false, defaultValue = "asc") String order){
        return ResponseEntity.ok(categoryHandler.getAllCategories(page, size, order));
    }

    @PutMapping
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryDTO category){
        categoryHandler.updateCategory(category);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryHandler.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
