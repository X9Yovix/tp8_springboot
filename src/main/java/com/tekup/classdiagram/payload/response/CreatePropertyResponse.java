package com.tekup.classdiagram.payload.response;

import com.tekup.classdiagram.model.Property;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePropertyResponse {
    private Property property;
    private String message;
    private int httpStatus;
}
