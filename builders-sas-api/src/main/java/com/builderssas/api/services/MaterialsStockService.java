package com.builderssas.api.services;

import com.builderssas.api.domain.model.material.dto.CreateMaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.MaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.UpdateMaterialsStockDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface MaterialsStockService {

    CompletableFuture<List<MaterialsStockDto>> getAllStocks();

    CompletableFuture<MaterialsStockDto> getStockById(Long id);

    CompletableFuture<MaterialsStockDto> createStock(CreateMaterialsStockDto dto);

    CompletableFuture<MaterialsStockDto> updateStock(Long id, UpdateMaterialsStockDto dto);

    CompletableFuture<Void> deleteStock(Long id);
}
