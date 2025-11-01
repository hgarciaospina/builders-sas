package com.builderssas.api.services.impl;

import com.builderssas.api.domain.model.material.dto.CreateMaterialTypeDto;
import com.builderssas.api.domain.model.material.dto.MaterialTypeDto;
import com.builderssas.api.domain.model.material.dto.UpdateMaterialTypeDto;
import com.builderssas.api.mapper.material.MaterialTypeMapper;
import com.builderssas.api.repository.MaterialTypeRepository;
import com.builderssas.api.services.MaterialTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Functional and non-blocking implementation of MaterialTypeService.
 * Uses CompletableFutures and MapStruct for all data transformations.
 */
@Service
@RequiredArgsConstructor
public class MaterialTypeServiceImpl implements MaterialTypeService {

    private final MaterialTypeRepository repository;
    private final MaterialTypeMapper mapper;

    @Override
    public CompletableFuture<MaterialTypeDto> create(MaterialTypeDto dto) {
        CreateMaterialTypeDto createDto = new CreateMaterialTypeDto();
        createDto.setCode(dto.getCode());
        createDto.setName(dto.getName());

        // Functional non-blocking creation
        return repository.existsByCode(dto.getCode())
                .thenCompose(optionalExists ->
                        optionalExists.orElse(false)
                                ? CompletableFuture.failedFuture(
                                new IllegalArgumentException("MaterialType with code " + dto.getCode() + " already exists"))
                                : repository.save(mapper.toEntity(createDto))
                                .toFuture()
                                .thenApply(mapper::toDto)
                );
    }

    @Override
    public CompletableFuture<MaterialTypeDto> update(Long id, MaterialTypeDto dto) {
        UpdateMaterialTypeDto updateDto = new UpdateMaterialTypeDto();
        updateDto.setName(dto.getName());

        // Functional non-blocking update
        return repository.findById(id)
                .toFuture()
                .thenCompose(optionalEntity ->
                        Optional.ofNullable(optionalEntity)
                                .map(existing -> {
                                    mapper.updateEntityFromDto(updateDto, existing);
                                    return repository.save(existing)
                                            .toFuture()
                                            .thenApply(mapper::toDto);
                                })
                                .orElseGet(() -> CompletableFuture.failedFuture(
                                        new IllegalArgumentException("MaterialType not found with id: " + id)))
                );
    }

    @Override
    public CompletableFuture<Void> delete(Long id) {
        return repository.deleteById(id).toFuture();
    }

    @Override
    public CompletableFuture<MaterialTypeDto> getById(Long id) {
        return repository.findById(id)
                .toFuture()
                .thenApply(entity -> {
                    if (entity == null)
                        throw new IllegalArgumentException("MaterialType not found with id: " + id);
                    return mapper.toDto(entity);
                });
    }

    @Override
    public CompletableFuture<List<MaterialTypeDto>> getAll() {
        return repository.findAll()
                .collectList()
                .toFuture()
                .thenApply(mapper::toDtos);
    }
}