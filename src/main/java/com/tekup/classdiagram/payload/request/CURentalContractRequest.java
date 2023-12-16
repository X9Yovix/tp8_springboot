package com.tekup.classdiagram.payload.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CURentalContractRequest {
    @NotNull(message = "Property Id is required")
    private Long propertyId;

    @NotNull(message = "Owner Id Rent is required")
    private Long ownerId;

    @NotBlank(message = "Tenant is required")
    @Pattern(regexp = "[A-Za-z ]+", message = "Tenant must contain only letters and spaces")
    @Size(max = 255, message = "Tenant must be at most 255 characters")
    private String tenant;

    @NotNull(message = "Monthly Rent is required")
    @Positive(message = "Monthly Rent must be greater than zero")
    private double monthlyRent;
}
