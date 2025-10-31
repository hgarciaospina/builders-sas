package com.builderssas.api.domain.model.user.dto;

import lombok.*;
import java.util.Set;

/**
 * DTO for creating a new user.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Set<Long> roleIds;
}