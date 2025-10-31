package com.builderssas.api.domain.model.user.dto;

import lombok.*;
import java.time.OffsetDateTime;

/**
 * DTO for creating a new UserRole.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRoleDto {

    /** User ID to associate with this role. */
    private Long userId;

    /** Role ID to assign to the user. */
    private Long roleId;

    /** Optional timestamp when the role is assigned. */
    private OffsetDateTime assignedAt;
}
