package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.PlayerDTO;
import org.example.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/info/{id}")
    public ResponseEntity<PlayerDTO> getPlayer(@PathVariable String id) {
        return ResponseEntity.ok(playerService.getById(id));
    }

    @GetMapping("/info")
    public ResponseEntity<List<PlayerDTO>> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(playerService.getByName(name));
    }
}
