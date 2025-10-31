package com.builderssas.api.domain.model.user.dto;

import lombok.*;

/**
 * DTO for returning role information.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private String name;
    private String description;
}