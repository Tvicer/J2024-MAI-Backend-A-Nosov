package org.example.repository;

import org.example.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, String> {
    Optional<PlayerEntity> findById(String id);

    List<PlayerEntity> findByNameContainingIgnoreCaseOrderByName(String name);

    List<PlayerEntity> findAll();
}
