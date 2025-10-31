package com.builderssas.api.domain.model.project;

import com.builderssas.api.domain.model.construction.ConstructionOrder;
import com.builderssas.api.domain.model.construction.ConstructionRequest;
import com.builderssas.api.domain.model.enums.ProjectStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a construction project (e.g., "Ciudadela del Futuro").
 *
 * Design notes:
 * - Each project must have an architect (ON DELETE RESTRICT).
 * - Deleting a project cascades to remove its dependent constructions, reservations, and cancellations.
 * - The project status is persisted as a STRING from the ProjectStatus enum.
 * - Relationships are initialized by default to ensure collection safety.
 */
@Entity
@Table(
        name = "projects",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_projects_name", columnNames = "name")
        },
        indexes = {
                @Index(name = "idx_project_name", columnList = "name"),
                @Index(name = "idx_project_status", columnList = "project_status")
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Project {

    /** Primary key — unique identifier for the project. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    /** Unique name of the project (e.g., "Residential Complex A"). */
    @Column(nullable = false, length = 200)
    private String name;

    /** Optional detailed description of the project. */
    @Column(columnDefinition = "TEXT")
    private String description;

    /** Project start date (optional). */
    @Column(name = "start_date")
    private LocalDate startDate;

    /** Current project status (enum persisted as STRING). */
    @Enumerated(EnumType.STRING)
    @Column(name = "project_status", nullable = false, length = 20)
    @Builder.Default
    private ProjectStatus projectStatus = ProjectStatus.PLANNED;

    /**
     * Construction types associated with this project.
     * Deletion of the project cascades to remove all related constructions.
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<ProjectConstruction> constructions = new HashSet<>();

    /**
     * Construction orders associated with this project.
     * Prevent deletion of project if orders exist.
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<ConstructionOrder> orders = new HashSet<>();

    /**
     * Construction requests associated with this project.
     * Prevent deletion of project if requests exist.
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<ConstructionRequest> requests = new HashSet<>();
}
