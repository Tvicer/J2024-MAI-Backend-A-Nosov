package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.AvatarDTO;
import org.example.service.AvatarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avatar")
@RequiredArgsConstructor
public class AvatarController {

    private final AvatarService avatarService;

    @GetMapping("/info/{id}")
    public ResponseEntity<AvatarDTO> getAvatar(@PathVariable String id) {
        return ResponseEntity.ok(avatarService.getById(id));
    }

    @GetMapping("/info")
    public ResponseEntity<List<AvatarDTO>> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(avatarService.getByName(name));
    }
}
