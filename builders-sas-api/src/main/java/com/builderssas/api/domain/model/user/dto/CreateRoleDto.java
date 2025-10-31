package com.builderssas.api.domain.model.user.dto;

import lombok.*;

/**
 * DTO for creating a new Role.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleDto {

    /** Role name (e.g., ADMIN, ARCHITECT). */
    private String name;

    /** Optional description of the role. */
    private String description;
}
