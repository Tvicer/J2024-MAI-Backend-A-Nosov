package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class PlayerEntity {
    @Id
    private String id;

    @Column
    private String name;

    @OneToOne
    private AvatarEntity avatar;
}

