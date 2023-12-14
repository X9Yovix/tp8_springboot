package com.tekup.classdiagram.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "properties")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "price", nullable = false)
    private double price;
}
