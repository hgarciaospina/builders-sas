package com.builderssas.api.services;

import com.builderssas.api.domain.model.construction.dto.ConstructionRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
@Service
public interface ConstructionRequestService {

    CompletableFuture<ConstructionRequestDto> createRequest(ConstructionRequestDto dto);

    CompletableFuture<ConstructionRequestDto> updateRequest(Long id, ConstructionRequestDto dto);

    CompletableFuture<Boolean> deleteRequest(Long id);

    CompletableFuture<ConstructionRequestDto> getById(Long id);

    CompletableFuture<List<ConstructionRequestDto>> getAll();
}
