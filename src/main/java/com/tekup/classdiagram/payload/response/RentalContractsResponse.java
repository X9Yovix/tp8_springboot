package com.tekup.classdiagram.payload.response;

import com.tekup.classdiagram.model.RentalContract;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalContractsResponse {
    private List<RentalContract> rentalContracts;
    private String message;
    private int httpStatus;
}
