package com.builderssas.api.repository;

import com.builderssas.api.domain.model.construction.ConstructionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ConstructionTypeRepository extends ReactiveCrudRepository<ConstructionType, Long> {
    @Async
    CompletableFuture<Optional<ConstructionType>> findByName(String name);
}
