package com.builderssas.api.repository;

import com.builderssas.api.domain.model.construction.ConstructionTypeMaterial;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ConstructionTypeMaterialRepository extends ReactiveCrudRepository<ConstructionTypeMaterial, Long> {
    @Async
    CompletableFuture<Optional<ConstructionTypeMaterial>> findByConstructionTypeIdAndMaterialTypeId(Long constructionTypeId, Long materialTypeId);
}
