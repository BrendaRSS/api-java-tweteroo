package com.tweteroo.api.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank
    @URL(message = "The type must be a URL")
    private String avatar;

    @NotBlank
    private String username;
    
}
