package com.builderssas.api.repository;

import com.builderssas.api.domain.model.material.MaterialsStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface MaterialsStockRepository extends ReactiveCrudRepository<MaterialsStock, Long> {
    @Async
    CompletableFuture<Optional<MaterialsStock>> findByMaterialTypeId(Long materialTypeId);
}
