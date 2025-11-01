package com.builderssas.api.controller.construction;

import com.builderssas.api.domain.model.construction.dto.ConstructionRequestDto;
import com.builderssas.api.services.ConstructionRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Functional and concurrent REST controller for Construction Requests.
 * Uses CompletableFuture to ensure non-blocking operations and concurrent request handling.
 */
@RestController
@RequestMapping("/api/construction-requests")
public class ConstructionRequestController {

    private final ConstructionRequestService service;

    /**
     * Constructor for dependency injection.
     * Initializes the final service field to ensure proper Spring injection.
     *
     * @param service the ConstructionRequestService to handle business logic
     */
    public ConstructionRequestController(ConstructionRequestService service) {
        this.service = service;
    }

    /**
     * Create a new Construction Request asynchronously.
     *
     * @param dto the ConstructionRequestDto containing the request data
     * @return CompletableFuture with ResponseEntity wrapping the created DTO
     */
    @PostMapping
    public CompletableFuture<ResponseEntity<ConstructionRequestDto>> createRequest(
            @RequestBody ConstructionRequestDto dto) {

        return service.createRequest(dto)
                .thenApply(created -> ResponseEntity.ok(created))
                .exceptionally(ex -> ResponseEntity.badRequest().body(null));
    }

    /**
     * Update an existing Construction Request asynchronously.
     *
     * @param id  the ID of the request to update
     * @param dto the updated ConstructionRequestDto
     * @return CompletableFuture with ResponseEntity wrapping the updated DTO
     */
    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<ConstructionRequestDto>> updateRequest(
            @PathVariable Long id,
            @RequestBody ConstructionRequestDto dto) {

        return service.updateRequest(id, dto)
                .thenApply(updated -> ResponseEntity.ok(updated))
                .exceptionally(ex -> ResponseEntity.notFound().build());
    }

    /**
     * Delete a Construction Request asynchronously.
     *
     * @param id the ID of the request to delete
     * @return CompletableFuture with ResponseEntity indicating success or failure
     */
    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Object>> deleteRequest(@PathVariable Long id) {
        return service.deleteRequest(id)
                .thenApply(success -> success ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build())
                .exceptionally(ex -> ResponseEntity.internalServerError().build());
    }

    /**
     * Retrieve a Construction Request by ID asynchronously.
     *
     * @param id the ID of the request to retrieve
     * @return CompletableFuture with ResponseEntity wrapping the retrieved DTO
     */
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<?>> getById(@PathVariable Long id) {
        return service.getById(id)
                .thenApply(dto -> dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build())
                .exceptionally(ex -> ResponseEntity.internalServerError().build());
    }

    /**
     * Retrieve all Construction Requests asynchronously.
     *
     * @return CompletableFuture with ResponseEntity wrapping the list of DTOs
     */
    @GetMapping
    public CompletableFuture<ResponseEntity<List<ConstructionRequestDto>>> getAll() {
        return service.getAll()
                .thenApply(list -> ResponseEntity.ok(list))
                .exceptionally(ex -> ResponseEntity.internalServerError().build());
    }
}
