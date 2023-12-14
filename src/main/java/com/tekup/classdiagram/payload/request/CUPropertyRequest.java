package com.tekup.classdiagram.payload.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CUPropertyRequest {
    private String address;
    private double price;
}
