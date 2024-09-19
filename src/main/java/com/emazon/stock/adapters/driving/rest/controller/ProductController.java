package com.emazon.stock.adapters.driving.rest.controller;

import com.emazon.stock.adapters.driving.rest.dto.request.AddSuppliesRequestDTO;
import com.emazon.stock.adapters.driving.rest.dto.request.PaginationRequest;
import com.emazon.stock.adapters.driving.rest.dto.request.ProductRequest;
import com.emazon.stock.adapters.driving.rest.dto.response.PageResponse;
import com.emazon.stock.adapters.driving.rest.dto.response.ProductResponse;
import com.emazon.stock.adapters.driving.rest.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Adds a new product with its brand and categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product added", content = @Content),
            @ApiResponse(responseCode = "404", description = "Associated brand doesn't exist", content = @Content),
            @ApiResponse(responseCode = "409", description = "Some categories are duplicated", content = @Content),
            @ApiResponse(responseCode = "404", description = "One of the associated categories don't exist", content = @Content),
            @ApiResponse(responseCode = "400", description = "Some of the required attributes is null", content = @Content),
            @ApiResponse(responseCode = "400", description = "Product name is too long", content = @Content),
            @ApiResponse(responseCode = "400", description = "Product description is too long", content = @Content)
    })
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest product) {
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all products with its brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of the found products", content = @Content)
    })
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_AUX_BODEGA','ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<PageResponse<ProductResponse>> getAllProducts(@RequestParam Map<String, String> params){
        PageResponse<ProductResponse> foundProducts;
        PaginationRequest paginationRequest = new PaginationRequest(params);
        foundProducts = productService.getAllProducts(paginationRequest);
        return ResponseEntity.ok(foundProducts);
    }

    @Operation(summary = "Change the amount of stock products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Amount products changed", content = @Content)
    })
    @PutMapping("/addSupplies")
    @PreAuthorize("hasAnyAuthority('ROLE_AUX_BODEGA')")
    public ResponseEntity<?> addSupplies(@Valid @RequestBody AddSuppliesRequestDTO addSupplies){
        productService.addSupplies(addSupplies);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
