package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "avatar")
public class AvatarEntity {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private Integer level;

    //@ManyToMany
    //private WeaponEntity player;
}

