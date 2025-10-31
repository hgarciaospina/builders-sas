package com.builderssas.api.repository;

import com.builderssas.api.domain.model.material.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface MaterialTypeRepository extends ReactiveCrudRepository<MaterialType, Long> {
    @Async
    CompletableFuture<Optional<MaterialType>> findByCode(String code);
}
