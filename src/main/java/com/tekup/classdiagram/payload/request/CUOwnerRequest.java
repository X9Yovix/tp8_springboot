package com.tekup.classdiagram.payload.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CUOwnerRequest {
    private String name;
    private String contactInformation;
}
