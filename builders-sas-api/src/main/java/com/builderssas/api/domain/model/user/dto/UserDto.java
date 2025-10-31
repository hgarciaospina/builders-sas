package com.builderssas.api.domain.model.user.dto;

import lombok.*;
import java.util.Set;

/**
 * DTO for returning user information in CRUD operations.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Boolean active;
    private Set<RoleDto> roles;
}
