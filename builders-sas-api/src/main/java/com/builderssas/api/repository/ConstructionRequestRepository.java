package com.builderssas.api.repository;

import com.builderssas.api.domain.model.construction.ConstructionRequest;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ConstructionRequestRepository extends R2dbcRepository<ConstructionRequest, Long> {
    Mono<ConstructionRequest> findByLatitudeAndLongitude(Double latitude, Double longitude);
}
