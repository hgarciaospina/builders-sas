package com.builderssas.api.domain.model.construction;

import com.builderssas.api.domain.model.project.Project;
import com.builderssas.api.domain.model.user.User;
import com.builderssas.api.domain.model.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

/**
 * Represents a construction request made by an architect.
 *
 * Rules:
 * - Each request specifies a construction type and unique coordinates.
 * - Only architects can submit requests.
 * - Once validated and approved, an order is created from this request.
 */
@Entity
@Table(
        name = "construction_requests",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_request_coordinates",
                        columnNames = {"coordinate_x", "coordinate_y"}
                )
        },
        indexes = {
                @Index(name = "idx_request_status", columnList = "request_status"),
                @Index(name = "idx_request_date", columnList = "request_date")
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConstructionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "project_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_request_project",
                    foreignKeyDefinition = "FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE RESTRICT"
            )
    )
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "construction_type_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_request_construction_type",
                    foreignKeyDefinition = "FOREIGN KEY (construction_type_id) REFERENCES construction_types(id) ON DELETE RESTRICT"
            )
    )
    private ConstructionType constructionType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "requested_by_user_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_request_user",
                    foreignKeyDefinition = "FOREIGN KEY (requested_by_user_id) REFERENCES users(id) ON DELETE RESTRICT"
            )
    )
    private User requestedBy;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "request_date", nullable = false)
    private LocalDate requestDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "request_status", nullable = false, length = 20)
    @Builder.Default
    private RequestStatus requestStatus = RequestStatus.PENDING;

    /**
     * Orders created from this request.
     * Ensures that a request cannot be deleted if it already generated orders.
     */
    @OneToMany(mappedBy = "constructionRequest", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<ConstructionOrder> orders = new HashSet<>();
}
