package org.example.repository;

import org.example.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {
    Optional<PersonEntity> findById(String id);

    List<PersonEntity> findByNameContainingIgnoreCaseOrderByName(String name);

    List<PersonEntity> findAll();
}
