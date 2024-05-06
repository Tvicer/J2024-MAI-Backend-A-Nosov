package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private Integer age;

    @OneToOne
    private PlayerEntity player;
}

