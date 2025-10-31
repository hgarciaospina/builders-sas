package com.builderssas.api.domain.model.material;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a catalog entry defining a construction material type.
 *
 * Each MaterialType identifies a specific material kind (e.g., Cement, Gravel, Sand, Wood, Adobe)
 * using a unique short code.
 *
 * Design notes:
 * - The 'code' field is unique to prevent duplication (e.g., CE, GR, SA, WO, AD).
 * - Relationships with MaterialsStock enforce ON DELETE RESTRICT behavior through foreign key constraints.
 * - Cascade operations are intentionally avoided to prevent accidental deletions.
 * - Each MaterialType can have multiple associated MaterialsStock entries.
 */
@Entity
@Table(
        name = "material_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_material_types_code",
                        columnNames = "code"
                )
        },
        indexes = {
                @Index(name = "idx_material_type_code", columnList = "code"),
                @Index(name = "idx_material_type_name", columnList = "name")
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MaterialType {

    /** Primary key — unique identifier for the material type. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    /** Unique short code used to identify the material type (e.g., CE, GR, SA, WO, AD). */
    @Column(name = "code", nullable = false, length = 10, unique = true)
    private String code;

    /** Descriptive name of the material type. */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * One-to-many relationship with MaterialsStock representing all stock entries for this material type.
     *
     * Notes:
     * - Cascade operations are not used to preserve stock integrity.
     * - ON DELETE RESTRICT is handled by the database foreign key in MaterialsStock.
     * - The collection is initialized by default to avoid null references.
     */
    @OneToMany(mappedBy = "materialType", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MaterialsStock> stocks = new HashSet<>();
}