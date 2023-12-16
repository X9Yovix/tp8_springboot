package com.tekup.classdiagram.payload.response;

import com.tekup.classdiagram.model.RentalContract;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CURentalContractResponse {
    private RentalContract rentalContract;
    private String message;
    private int httpStatus;
}
