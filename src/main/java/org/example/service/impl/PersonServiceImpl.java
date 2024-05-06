package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.PersonDTO;
import org.example.entity.PersonEntity;
import org.example.repository.PersonRepository;
import org.example.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final ModelMapper mapper;
    private final PersonRepository personRepository;

    @Override
    public PersonDTO getById(String id) {
        var optionalPersonEntity = personRepository.findById(id);
        if (optionalPersonEntity.isEmpty()) {
            return new PersonDTO();
        }

        var personOptional = personRepository.findById(id);
        var personEntity = personOptional.orElse(new PersonEntity());
        return mapper.map(personEntity, PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getByName(String name) {
        var personEntities = personRepository.findByNameContainingIgnoreCaseOrderByName(name);
        return personEntities.stream()
                .map(personEntity -> mapper.map(personEntity, PersonDTO.class))
                .toList();
    }

    @Override
    public List<PersonDTO> getAll() {
        return personRepository.findAll()
                .stream()
                .map(personEntity -> mapper.map(personEntity, PersonDTO.class))
                .toList();
    }
}
