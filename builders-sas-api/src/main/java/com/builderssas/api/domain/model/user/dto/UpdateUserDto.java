package com.builderssas.api.domain.model.user.dto;

import lombok.*;

import java.util.Set;

/**
 * DTO for updating an existing user.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Boolean active;
    private Set<Long> roleIds;
}