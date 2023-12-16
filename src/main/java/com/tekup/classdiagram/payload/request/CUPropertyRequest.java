package com.tekup.classdiagram.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CUPropertyRequest {
    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Price Rent is required")
    private double price;
}
