package com.builderssas.api.controller.materialsstock;

import com.builderssas.api.domain.model.material.dto.CreateMaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.MaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.UpdateMaterialsStockDto;
import com.builderssas.api.services.MaterialsStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * REST controller for managing Materials Stock.
 * All operations are asynchronous using CompletableFuture to support non-blocking request handling.
 */
@RestController
@RequestMapping("/api/materials-stock")
public class MaterialsStockController {

    private final MaterialsStockService stockService;

    /**
     * Constructor for dependency injection.
     * Initializes the final stockService field to ensure proper Spring injection.
     *
     * @param stockService the MaterialsStockService to handle business logic
     */
    public MaterialsStockController(MaterialsStockService stockService) {
        this.stockService = stockService;
    }

    /**
     * Retrieve all materials stock asynchronously.
     *
     * @return CompletableFuture with ResponseEntity wrapping a list of MaterialsStockDto
     */
    @GetMapping
    public CompletableFuture<ResponseEntity<List<MaterialsStockDto>>> getAll() {
        return stockService.getAllStocks()
                .thenApply(ResponseEntity::ok);
    }

    /**
     * Retrieve a material stock by ID asynchronously.
     *
     * @param id the ID of the stock to retrieve
     * @return CompletableFuture with ResponseEntity wrapping the stock, or 404 if not found
     */
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<MaterialsStockDto>> getById(@PathVariable Long id) {
        return stockService.getStockById(id)
                .thenApply(stock -> stock != null ? ResponseEntity.ok(stock) : ResponseEntity.notFound().build());
    }

    /**
     * Create a new material stock asynchronously.
     *
     * @param dto the CreateMaterialsStockDto containing stock details
     * @return CompletableFuture with ResponseEntity wrapping the created stock
     */
    @PostMapping
    public CompletableFuture<ResponseEntity<MaterialsStockDto>> create(@RequestBody CreateMaterialsStockDto dto) {
        return stockService.createStock(dto)
                .thenApply(ResponseEntity::ok);
    }

    /**
     * Update an existing material stock asynchronously.
     *
     * @param id  the ID of the stock to update
     * @param dto the UpdateMaterialsStockDto containing updated details
     * @return CompletableFuture with ResponseEntity wrapping the updated stock
     */
    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<MaterialsStockDto>> update(@PathVariable Long id, @RequestBody UpdateMaterialsStockDto dto) {
        return stockService.updateStock(id, dto)
                .thenApply(ResponseEntity::ok);
    }

    /**
     * Delete a material stock asynchronously.
     *
     * @param id the ID of the stock to delete
     * @return CompletableFuture with ResponseEntity indicating success
     */
    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return stockService.deleteStock(id)
                .thenApply(v -> ResponseEntity.noContent().build());
    }
}
