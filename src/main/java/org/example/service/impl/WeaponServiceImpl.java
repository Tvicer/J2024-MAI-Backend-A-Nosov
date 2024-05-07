package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.WeaponDTO;
import org.example.entity.WeaponEntity;
import org.example.repository.WeaponRepository;
import org.example.service.WeaponService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeaponServiceImpl implements WeaponService {

    private final ModelMapper mapper;
    private final WeaponRepository weaponRepository;

    @Override
    public WeaponDTO getById(String id) {
        var optionalWeaponEntity = weaponRepository.findById(id);
        if (optionalWeaponEntity.isEmpty()) {
            return new WeaponDTO();
        }

        var weaponOptional = weaponRepository.findById(id);
        var weaponEntity = weaponOptional.orElse(new WeaponEntity());
        return mapper.map(weaponEntity, WeaponDTO.class);
    }

    @Override
    public List<WeaponDTO> getByName(String name) {
        var weaponEntities = weaponRepository.findByNameContainingIgnoreCaseOrderByName(name);
        return weaponEntities.stream()
                .map(weaponEntity -> mapper.map(weaponEntity, WeaponDTO.class))
                .toList();
    }

    @Override
    public List<WeaponDTO> getAll() {
        return weaponRepository.findAll()
                .stream()
                .map(weaponEntity -> mapper.map(weaponEntity, WeaponDTO.class))
                .toList();
    }
}
