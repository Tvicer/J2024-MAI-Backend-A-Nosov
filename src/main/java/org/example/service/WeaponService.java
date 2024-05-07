package org.example.service;

import org.example.dto.WeaponDTO;

import java.util.List;

public interface WeaponService {
    WeaponDTO getById(String id);

    List<WeaponDTO> getByName(String name);

    List<WeaponDTO> getAll();
}
