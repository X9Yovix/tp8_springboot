package com.tekup.classdiagram.payload.response;

import com.tekup.classdiagram.model.Property;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertiesResponse {
    private List<Property> properties;
    private String message;
    private int httpStatus;
}
