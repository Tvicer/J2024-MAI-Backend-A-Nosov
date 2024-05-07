package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.WeaponDTO;
import org.example.entity.WeaponEntity;
import org.example.service.WeaponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weapon")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponService weaponService;

    @GetMapping("/info/{id}")
    public ResponseEntity<WeaponDTO> getWeapon(@PathVariable String id) {
        return ResponseEntity.ok(weaponService.getById(id));
    }

    @GetMapping("/info")
    public ResponseEntity<List<WeaponDTO>> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(weaponService.getByName(name));
    }

    @PostMapping("/add")
    public ResponseEntity<WeaponDTO> save(@RequestParam("id") Integer id,
                                             @RequestParam("name") String name,
                                             @RequestParam("damage") Integer damage) {
        return ResponseEntity.ok(weaponService.save(id, name, damage));
    }
}
