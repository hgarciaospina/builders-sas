package com.builderssas.api.domain.model.material;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity representing the global inventory of materials by type.
 *
 * Each record in this table defines the current quantity available for a specific MaterialType.
 *
 * Design notes:
 * - Each MaterialType has a single stock record (unique constraint).
 * - Relationship with MaterialType is mandatory (optional = false).
 * - Cascade operations are avoided to prevent accidental deletions.
 * - ON DELETE RESTRICT ensures that a MaterialType cannot be deleted if referenced by stock.
 * - Quantity cannot be null and defaults to zero.
 */
@Entity
@Table(
        name = "materials_stock",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_stock_material",
                        columnNames = "material_type_id"
                )
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MaterialsStock {

    /** Primary key — unique identifier for the material stock record. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    /** Reference to the material type this stock record corresponds to. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "material_type_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_stock_material_type",
                    foreignKeyDefinition = "FOREIGN KEY (material_type_id) REFERENCES material_types(id) ON DELETE RESTRICT"
            )
    )
    private MaterialType materialType;

    /** Current quantity available for the material type. */
    @Column(nullable = false)
    private Long quantity = 0L;
}
