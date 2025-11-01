package com.builderssas.api.repository;

import com.builderssas.api.domain.model.material.MaterialsStock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
@Repository
public interface MaterialsStockRepository extends ReactiveCrudRepository<MaterialsStock, Long> {
    @Async
    CompletableFuture<Optional<MaterialsStock>> findByMaterialTypeId(Long materialTypeId);
}
