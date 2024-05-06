package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.PlayerDTO;
import org.example.entity.PlayerEntity;
import org.example.repository.PlayerRepository;
import org.example.service.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final ModelMapper mapper;
    private final PlayerRepository playerRepository;

    @Override
    public PlayerDTO getById(String id) {
        var optionalPlayerEntity = playerRepository.findById(id);
        if (optionalPlayerEntity.isEmpty()) {
            return new PlayerDTO();
        }

        var playerOptional = playerRepository.findById(id);
        var playerEntity = playerOptional.orElse(new PlayerEntity());
        return mapper.map(playerEntity, PlayerDTO.class);
    }

    @Override
    public List<PlayerDTO> getByName(String name) {
        var playerEntities = playerRepository.findByNameContainingIgnoreCaseOrderByName(name);
        return playerEntities.stream()
                .map(playerEntity -> mapper.map(playerEntity, PlayerDTO.class))
                .toList();
    }

    @Override
    public List<PlayerDTO> getAll() {
        return playerRepository.findAll()
                .stream()
                .map(playerEntity -> mapper.map(playerEntity, PlayerDTO.class))
                .toList();
    }
}
