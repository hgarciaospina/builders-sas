package com.builderssas.api.domain.model.user.dto;

import lombok.*;

/**
 * DTO for deleting a UserRole record.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserRoleDto {

    /** Primary key — ID of the UserRole to delete. */
    private Long id;
}
