package com.stupnv.vocabulary.model;

import jakarta.persistence.*;

@Entity()
@Table(
        name = "unit"
)
public class Unit {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "title"
    )
    String title;
}
