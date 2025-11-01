package com.builderssas.api.repository;

import com.builderssas.api.domain.model.material.MaterialType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
@Repository
public interface MaterialTypeRepository extends ReactiveCrudRepository<MaterialType, Long> {
    @Async
    CompletableFuture<Optional<MaterialType>> findByCode(String code);
    @Async
    CompletableFuture<Optional<Boolean>> existsByCode(String code);
}