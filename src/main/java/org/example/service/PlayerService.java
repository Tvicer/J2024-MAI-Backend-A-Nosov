package org.example.service;

import org.example.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    PlayerDTO getById(String id);

    List<PlayerDTO> getByName(String name);

    List<PlayerDTO> getAll();
}
