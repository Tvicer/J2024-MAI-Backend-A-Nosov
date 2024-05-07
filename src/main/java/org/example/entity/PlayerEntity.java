package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "player")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column
    private String name;

    @OneToOne
    private AvatarEntity avatar;
}

