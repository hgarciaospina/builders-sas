package com.builderssas.api.domain.model.user.dto;

import lombok.*;

/**
 * DTO for updating an existing role.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleDto {
    private String name;
    private String description;
}