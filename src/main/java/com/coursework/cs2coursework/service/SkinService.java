package com.coursework.cs2coursework.service;

import com.coursework.cs2coursework.dto.SkinDto;
import com.coursework.cs2coursework.entity.Skin;
import com.coursework.cs2coursework.mapper.SkinMapper;
import com.coursework.cs2coursework.repository.SkinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkinService {
    private final SkinRepository skinRepository;


    public SkinDto createSkin(SkinDto dto) {
        Skin skin = SkinMapper.toEntity(dto);
        skinRepository.save(skin);
        return SkinMapper.toDto(skin);
    }


    public SkinDto getSkinById(Long id) {
        Skin skin = skinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skin not found"));
        return SkinMapper.toDto(skin);
    }


    public List<SkinDto> getAllSkins() {
        return skinRepository.findAll().stream()
                .map(SkinMapper::toDto)
                .collect(Collectors.toList());
    }
}