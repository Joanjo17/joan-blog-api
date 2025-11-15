package com.joanlica.joan_blog_api.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostRequestDTO(
        @NotBlank(message = "El título no puede estar en blanco")
        @Size(max = 100, min = 1, message = "La longitud del título no debe ser superior a 100.")
        String title,
        @NotBlank(message = "El título no puede estar en blanco")
        @Size(max = 300, min = 1, message = "La longitud del contenido no debe ser superior a 100.")
        String content,
        @NotBlank(message = "El título no puede estar en blanco")
        @Size(max = 100, min = 1, message = "La longitud del autor no debe ser superior a 100.")
        String author
) {
}