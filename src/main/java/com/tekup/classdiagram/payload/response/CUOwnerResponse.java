package com.tekup.classdiagram.payload.response;

import com.tekup.classdiagram.model.Owner;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CUOwnerResponse {
    private Owner owner;
    private String message;
    private int httpStatus;
}
