package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "avatar")
public class AvatarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column
    private String name;

    @Column
    private Integer level;

    @ManyToMany
    @JoinTable(
            name = "avatars_weapons",
            joinColumns = @JoinColumn(name = "avatars_id"),
            inverseJoinColumns = @JoinColumn(name = "weapons_id")
    )
    private List<WeaponEntity> weapon;
}

