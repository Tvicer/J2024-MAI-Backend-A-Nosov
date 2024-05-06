package org.example.service;

import org.example.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO getById(String id);

    List<PersonDTO> getByName(String name);

    List<PersonDTO> getAll();
}
