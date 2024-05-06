package org.example.repository;

import org.example.entity.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository<AvatarEntity, String> {
    Optional<AvatarEntity> findById(String id);

    List<AvatarEntity> findByNameContainingIgnoreCaseOrderByName(String name);

    List<AvatarEntity> findAll();
}
