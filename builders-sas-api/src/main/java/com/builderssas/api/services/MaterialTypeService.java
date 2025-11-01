package com.builderssas.api.services;

import com.builderssas.api.domain.model.material.dto.MaterialTypeDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Defines asynchronous and reactive CRUD operations for MaterialType.
 */
public interface MaterialTypeService {

    CompletableFuture<MaterialTypeDto> create(MaterialTypeDto dto);

    CompletableFuture<MaterialTypeDto> update(Long id, MaterialTypeDto dto);

    CompletableFuture<Void> delete(Long id);

    CompletableFuture<MaterialTypeDto> getById(Long id);

    CompletableFuture<List<MaterialTypeDto>> getAll();
}
