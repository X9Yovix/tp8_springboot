package com.tekup.classdiagram.payload.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreatePropertyRequest {
    private Long id;
    private String address;
    private double price;
}
