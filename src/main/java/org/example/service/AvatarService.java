package org.example.service;

import org.example.dto.AvatarDTO;

import java.util.List;

public interface AvatarService {
    AvatarDTO getById(String id);

    List<AvatarDTO> getByName(String name);

    List<AvatarDTO> getAll();
}
