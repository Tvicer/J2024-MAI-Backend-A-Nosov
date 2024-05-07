package org.example.repository;

import org.example.entity.WeaponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeaponRepository extends JpaRepository<WeaponEntity, String> {
    Optional<WeaponEntity> findById(String id);

    List<WeaponEntity> findByNameContainingIgnoreCaseOrderByName(String name);

    List<WeaponEntity> findAll();
}
