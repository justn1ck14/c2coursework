package com.coursework.cs2coursework.mapper;

import com.coursework.cs2coursework.dto.SkinDto;
import com.coursework.cs2coursework.entity.Skin;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SkinMapper {
    public static SkinDto toDto(Skin skin) {
        return new SkinDto(skin.getId(), skin.getName(), skin.getRarity(), skin.getImageUrl());
    }

    public static Skin toEntity(SkinDto dto) {
        return new Skin(dto.getId(), dto.getName(), dto.getRarity(), dto.getImageUrl());
    }
}