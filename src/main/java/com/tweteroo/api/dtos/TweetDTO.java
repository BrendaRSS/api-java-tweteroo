package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {
    @NotBlank(message = "Text is mandatory")
    @Size(max = 280)
    private String text;

    @NotNull
    private Long authorId; 
}
