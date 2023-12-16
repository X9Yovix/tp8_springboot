package com.tekup.classdiagram.payload.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CURentalContractRequest {
    private Long propertyId;
    private Long ownerId;
    private String tenant;
    private double monthlyRent;
}
