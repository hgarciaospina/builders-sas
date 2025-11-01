package com.builderssas.api.controller.materialtype;

import com.builderssas.api.domain.model.material.dto.MaterialTypeDto;
import com.builderssas.api.services.MaterialTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * REST controller exposing asynchronous CRUD endpoints for MaterialType.
 * Fully functional and non-blocking using CompletableFuture.
 */
@RestController
@RequestMapping("/api/v1/material-types")
public class MaterialTypeController {

    private final MaterialTypeService service;

    /**
     * Constructor for dependency injection.
     * Initializes the final service field to ensure proper Spring injection.
     *
     * @param service the MaterialTypeService to handle business logic
     */
    public MaterialTypeController(MaterialTypeService service) {
        this.service = service;
    }

    /**
     * Create a new material type asynchronously.
     */
    @PostMapping
    public CompletableFuture<ResponseEntity<MaterialTypeDto>> create(@RequestBody MaterialTypeDto dto) {
        return service.create(dto)
                .thenApply(created -> ResponseEntity.status(HttpStatus.CREATED).body(created))
                .exceptionally(ex ->
                        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    /**
     * Update an existing material type asynchronously.
     */
    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<MaterialTypeDto>> update(
            @PathVariable Long id,
            @RequestBody MaterialTypeDto dto) {
        return service.update(id, dto)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Delete a material type asynchronously.
     */
    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return service.delete(id)
                .thenApply(v -> ResponseEntity.noContent().<Void>build())
                .exceptionally(ex ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).<Void>build());
    }

    /**
     * Retrieve a material type by ID asynchronously.
     */
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<MaterialTypeDto>> getById(@PathVariable Long id) {
        return service.getById(id)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Retrieve all material types asynchronously.
     */
    @GetMapping
    public CompletableFuture<ResponseEntity<List<MaterialTypeDto>>> getAll() {
        return service.getAll()
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex ->
                        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(List.of()));
    }
}
