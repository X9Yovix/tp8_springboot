package com.tekup.classdiagram.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rental_contracts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class RentalContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "tenant")
    private String tenant;

    @Column(name = "monthly_rent")
    private double monthlyRent;
}
