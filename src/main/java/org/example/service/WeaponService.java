package org.example.service;

import org.example.dto.WeaponDTO;
import org.example.entity.WeaponEntity;

import java.util.List;

public interface WeaponService {
    WeaponDTO getById(String id);

    List<WeaponDTO> getByName(String name);

    List<WeaponDTO> getAll();

    WeaponDTO save(Integer id, String name, Integer damage);
}
