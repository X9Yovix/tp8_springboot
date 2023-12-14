package com.tekup.classdiagram.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "owners")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "contact_information", nullable = false)
    private String contactInformation;
}
