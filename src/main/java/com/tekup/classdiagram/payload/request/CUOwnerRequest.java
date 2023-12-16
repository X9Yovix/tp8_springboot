package com.tekup.classdiagram.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CUOwnerRequest {
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "[A-Za-z ]+", message = "Name must contain only letters and spaces")
    @Size(max = 255, message = "Name must be at most 255 characters")
    private String name;

    @NotBlank(message = "Contact Information is required")
    private String contactInformation;
}
