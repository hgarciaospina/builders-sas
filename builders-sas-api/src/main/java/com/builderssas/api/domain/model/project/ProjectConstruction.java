package com.builderssas.api.domain.model.project;

import com.builderssas.api.domain.model.construction.ConstructionOrder;
import com.builderssas.api.domain.model.construction.ConstructionType;
import com.builderssas.api.domain.model.enums.ConstructionStatus;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.HashSet;

/**
 * Represents the configuration of a specific construction type allowed within a project.
 *
 * Design notes:
 * - Defines which construction types are valid for this project.
 * - A construction type cannot be repeated in the same project.
 * - No quantity tracking, since construction requests define specific coordinates.
 * - Orders reference this configuration to ensure project compliance.
 */
@Entity
@Table(
        name = "project_constructions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_project_constructions_project_type",
                        columnNames = {"project_id", "construction_type_id"}
                )
        },
        indexes = {
                @Index(name = "idx_project_constructions_project", columnList = "project_id"),
                @Index(name = "idx_project_constructions_type", columnList = "construction_type_id")
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProjectConstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "project_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_project_constructions_project",
                    foreignKeyDefinition = "FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE RESTRICT"
            )
    )
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "construction_type_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_project_constructions_type",
                    foreignKeyDefinition = "FOREIGN KEY (construction_type_id) REFERENCES construction_types(id) ON DELETE RESTRICT"
            )
    )
    private ConstructionType constructionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "construction_status", nullable = false, length = 20)
    @Builder.Default
    private ConstructionStatus constructionStatus = ConstructionStatus.PENDING;

    @OneToMany(mappedBy = "projectConstruction", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<ConstructionOrder> orders = new HashSet<>();
}
