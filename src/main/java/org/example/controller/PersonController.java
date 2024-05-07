package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.PersonDTO;
import org.example.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/info/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable String id) {
        return ResponseEntity.ok(personService.getById(id));
    }

    @GetMapping("/info")
    public ResponseEntity<List<PersonDTO>> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(personService.getByName(name));
    }
}
