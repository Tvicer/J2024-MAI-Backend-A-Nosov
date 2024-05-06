package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.AvatarDTO;
import org.example.entity.AvatarEntity;
import org.example.repository.AvatarRepository;
import org.example.service.AvatarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {

    private final ModelMapper mapper;
    private final AvatarRepository avatarRepository;

    @Override
    public AvatarDTO getById(String id) {
        var optionalAvatarEntity = avatarRepository.findById(id);
        if (optionalAvatarEntity.isEmpty()) {
            return new AvatarDTO();
        }

        var avatarOptional = avatarRepository.findById(id);
        var avatarEntity = avatarOptional.orElse(new AvatarEntity());
        return mapper.map(avatarEntity, AvatarDTO.class);
    }

    @Override
    public List<AvatarDTO> getByName(String name) {
        var avatarEntities = avatarRepository.findByNameContainingIgnoreCaseOrderByName(name);
        return avatarEntities.stream()
                .map(personEntity -> mapper.map(avatarEntities, AvatarDTO.class))
                .toList();
    }

    @Override
    public List<AvatarDTO> getAll() {
        return avatarRepository.findAll()
                .stream()
                .map(avatarEntity -> mapper.map(avatarEntity, AvatarDTO.class))
                .toList();
    }
}
