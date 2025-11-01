package com.builderssas.api.services.impl;

import com.builderssas.api.domain.model.construction.ConstructionRequest;
import com.builderssas.api.domain.model.construction.dto.ConstructionRequestDto;
import com.builderssas.api.repository.ConstructionRequestRepository;
import com.builderssas.api.services.ConstructionRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class ConstructionRequestServiceImpl implements ConstructionRequestService {

    private final ConstructionRequestRepository repository;

    @Async
    @Override
    public CompletableFuture<ConstructionRequestDto> createRequest(ConstructionRequestDto dto) {
        return CompletableFuture.supplyAsync(() -> {
            ConstructionRequest entity = new ConstructionRequest();
            entity.setLatitude(dto.getLatitude());
            entity.setLongitude(dto.getLongitude());
            entity.setRequestDate(LocalDate.now());
            entity.setRequestStatus(dto.getRequestStatus());

            // Guardado no bloqueante con R2DBC (convertimos Mono a Future)
            return repository.save(entity)
                    .toFuture()
                    .thenApply(saved -> toDTO(saved))
                    .join();
        });
    }

    @Async
    @Override
    public CompletableFuture<ConstructionRequestDto> updateRequest(Long id, ConstructionRequestDto dto) {
        return repository.findById(id)
                .toFuture()
                .thenCompose(optionalEntity -> {
                    if (optionalEntity == null) {
                        return CompletableFuture.failedFuture(new RuntimeException("Request not found"));
                    }
                    ConstructionRequest entity = optionalEntity;
                    entity.setLatitude(dto.getLatitude());
                    entity.setLongitude(dto.getLongitude());
                    entity.setRequestStatus(dto.getRequestStatus());
                    return repository.save(entity)
                            .toFuture()
                            .thenApply(this::toDTO);
                });
    }

    @Async
    @Override
    public CompletableFuture<Boolean> deleteRequest(Long id) {
        return repository.deleteById(id)
                .toFuture()
                .thenApply(v -> true);
    }

    @Async
    @Override
    public CompletableFuture<ConstructionRequestDto> getById(Long id) {
        return repository.findById(id)
                .toFuture()
                .thenApply(this::toDTO);
    }

    @Async
    @Override
    public CompletableFuture<List<ConstructionRequestDto>> getAll() {
        return repository.findAll()
                .collectList()
                .toFuture()
                .thenApply(list -> list.stream().map(this::toDTO).collect(Collectors.toList()));
    }

    private ConstructionRequestDto toDTO(ConstructionRequest entity) {
        return ConstructionRequestDto.builder()
                .id(entity.getId())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .requestedDate(entity.getRequestDate())
                .requestStatus(entity.getRequestStatus())
                .build();
    }
}