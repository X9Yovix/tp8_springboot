package com.tekup.classdiagram.payload.response;

import com.tekup.classdiagram.model.Owner;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnersResponse {
    private List<Owner> owners;
    private String message;
    private int httpStatus;
}
