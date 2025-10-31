package com.builderssas.api.domain.model.construction;

import com.builderssas.api.domain.model.project.Project;
import com.builderssas.api.domain.model.project.ProjectConstruction;
import com.builderssas.api.domain.model.user.User;
import com.builderssas.api.domain.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/**
 * Entity representing a Construction Order within a Project.
 *
 * Design overview:
 * - Each ConstructionOrder originates from a validated ConstructionRequest.
 * - Defines the actual execution of one construction at a specific coordinate (x, y).
 * - Each order belongs to one project and one construction type.
 * - Coordinates (X, Y) are unique per project to avoid overlaps.
 *
 * Business rules:
 * - Orders can only be created if the corresponding request was approved.
 * - Orders start in PENDING status and progress through defined workflow states.
 * - Deletions are restricted (ON DELETE RESTRICT) for data integrity.
 */
@Entity
@Table(
        name = "construction_orders",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_order_project_coordinate",
                        columnNames = {"coordinate_x", "coordinate_y"}
                )
        },
        indexes = {
                @Index(name = "idx_order_status", columnList = "order_status"),
                @Index(name = "idx_order_requested_date", columnList = "requested_date")
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConstructionOrder {

    /** Primary key — unique identifier for the construction order. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    /**
     * Reference to the validated construction request that originated this order.
     * Mandatory relationship.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "construction_request_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_order_request",
                    foreignKeyDefinition = "FOREIGN KEY (construction_request_id) REFERENCES construction_requests(id) ON DELETE RESTRICT"
            )
    )
    private ConstructionRequest constructionRequest;

    /**
     * Reference to project construction configuration this order belongs to.
     * Mandatory relationship.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "project_construction_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_order_project_construction",
                    foreignKeyDefinition = "FOREIGN KEY (project_construction_id) REFERENCES project_constructions(id) ON DELETE RESTRICT"
            )
    )
    private ProjectConstruction projectConstruction;

    /**
     * Reference to the project this order belongs to.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "project_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_order_project",
                    foreignKeyDefinition = "FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE RESTRICT"
            )
    )
    private Project project;

    /**
     * Type of construction being executed in this order.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "construction_type_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_order_construction_type",
                    foreignKeyDefinition = "FOREIGN KEY (construction_type_id) REFERENCES construction_types(id) ON DELETE RESTRICT"
            )
    )
    private ConstructionType constructionType;

    /**
     * User who made the original request.
     * Comes from the ConstructionRequest entity.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "requested_by_user_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_order_requested_user",
                    foreignKeyDefinition = "FOREIGN KEY (requested_by_user_id) REFERENCES users(id) ON DELETE RESTRICT"
            )
    )
    private User requestedBy;

    /** Unique coordinate X within the project for this order. */
    @Column(name = "latitude", nullable = false)
    private Double latitude;

    /** Unique coordinate Y within the project for this order. */
    @Column(name = "longitude", nullable = false)
    private Double longitude;

    /** Date when the order was requested (from the original request). */
    @Column(name = "requested_date", nullable = false)
    private LocalDate requestedDate;

    /** Scheduled start date for construction (automatically calculated). */
    @Column(name = "scheduled_start_date")
    private LocalDate scheduledStartDate;

    /** Scheduled end date for construction (automatically calculated). */
    @Column(name = "scheduled_end_date")
    private LocalDate scheduledEndDate;

    /**
     * Current order status.
     * States: REQUESTED, PENDING, IN_PROGRESS, COMPLETED, CANCELLED.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false, length = 20)
    @Builder.Default
    private OrderStatus orderStatus = OrderStatus.PENDING;
}
