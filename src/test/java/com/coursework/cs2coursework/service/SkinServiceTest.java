package com.coursework.cs2coursework.service;

import com.coursework.cs2coursework.dto.SkinDto;
import com.coursework.cs2coursework.entity.Skin;
import com.coursework.cs2coursework.mapper.SkinMapper;
import com.coursework.cs2coursework.repository.SkinRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SkinServiceTest {
    @Mock
    private SkinRepository skinRepository;

    @InjectMocks
    private SkinService skinService;

    @Test
    void testCreateSkin() {
        SkinDto skinDto = new SkinDto(null, "Knife", "Rare", "image.png");
        when(skinRepository.save(any(Skin.class))).thenAnswer(invocation -> invocation.getArgument(0));

        SkinDto result = skinService.createSkin(skinDto);

        assertNotNull(result);
        assertEquals("Knife", result.getName());
        assertEquals("Rare", result.getRarity());
        verify(skinRepository, times(1)).save(any(Skin.class));
    }
}