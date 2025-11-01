package com.builderssas.api.controller.materialsstock;

import com.builderssas.api.domain.model.material.dto.CreateMaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.MaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.UpdateMaterialsStockDto;
import com.builderssas.api.services.MaterialsStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/materials-stock")
@RequiredArgsConstructor
public class MaterialsStockController {

    private final MaterialsStockService stockService;

    @GetMapping
    public CompletableFuture<ResponseEntity<List<MaterialsStockDto>>> getAll() {
        return stockService.getAllStocks()
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<MaterialsStockDto>> getById(@PathVariable Long id) {
        return stockService.getStockById(id)
                .thenApply(stock -> stock != null ? ResponseEntity.ok(stock) : ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<MaterialsStockDto>> create(@RequestBody CreateMaterialsStockDto dto) {
        return stockService.createStock(dto)
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<MaterialsStockDto>> update(@PathVariable Long id, @RequestBody UpdateMaterialsStockDto dto) {
        return stockService.updateStock(id, dto)
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return stockService.deleteStock(id)
                .thenApply(v -> ResponseEntity.noContent().build());
    }
}

