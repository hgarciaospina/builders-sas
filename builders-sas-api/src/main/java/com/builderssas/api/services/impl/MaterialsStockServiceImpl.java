package com.builderssas.api.services.impl;

import com.builderssas.api.domain.model.material.MaterialsStock;
import com.builderssas.api.domain.model.material.dto.CreateMaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.MaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.UpdateMaterialsStockDto;

import com.builderssas.api.repository.MaterialsStockRepository;
import com.builderssas.api.repository.MaterialTypeRepository;
import com.builderssas.api.services.MaterialsStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class MaterialsStockServiceImpl implements MaterialsStockService {

    private final MaterialsStockRepository stockRepository;
    private final MaterialTypeRepository materialTypeRepository;

    @Override
    public CompletableFuture<List<MaterialsStockDto>> getAllStocks() {
        return stockRepository.findAll()
                .publishOn(Schedulers.boundedElastic())
                .map(this::toDto)
                .collectList()
                .toFuture();
    }

    @Override
    public CompletableFuture<MaterialsStockDto> getStockById(Long id) {
        return stockRepository.findById(id)
                .publishOn(Schedulers.boundedElastic())
                .map(this::toDto)
                .toFuture();
    }

    @Override
    public CompletableFuture<MaterialsStockDto> createStock(CreateMaterialsStockDto dto) {
        return materialTypeRepository.findById(dto.getMaterialTypeId())
                .flatMap(materialType -> {
                    MaterialsStock stock = MaterialsStock.builder()
                            .materialType(materialType)
                            .quantity(dto.getQuantity())
                            .build();
                    return stockRepository.save(stock);
                })
                .map(this::toDto)
                .publishOn(Schedulers.boundedElastic())
                .toFuture();
    }

    @Override
    public CompletableFuture<MaterialsStockDto> updateStock(Long id, UpdateMaterialsStockDto dto) {
        return stockRepository.findById(id)
                .flatMap(stock -> {
                    stock.setQuantity(dto.getQuantity());
                    return stockRepository.save(stock);
                })
                .map(this::toDto)
                .publishOn(Schedulers.boundedElastic())
                .toFuture();
    }

    @Override
    public CompletableFuture<Void> deleteStock(Long id) {
        return stockRepository.deleteById(id)
                .publishOn(Schedulers.boundedElastic())
                .then()
                .toFuture();
    }

    private MaterialsStockDto toDto(MaterialsStock stock) {
        return MaterialsStockDto.builder()
                .id(stock.getId())
                .materialTypeId(stock.getMaterialType().getId())
                .quantity(stock.getQuantity())
                .build();
    }
}