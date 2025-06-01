package com.coursework.cs2coursework.controller;

import com.coursework.cs2coursework.dto.SkinDto;
import com.coursework.cs2coursework.service.SkinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skins")
@RequiredArgsConstructor
public class SkinController {
    private final SkinService skinService;

    @GetMapping("/{id}")
    public ResponseEntity<SkinDto> getSkinById(@PathVariable Long id) {
        return ResponseEntity.ok(skinService.getSkinById(id));
    }

    @GetMapping
    public ResponseEntity<List<SkinDto>> getAllSkins() {
        return ResponseEntity.ok(skinService.getAllSkins());
    }

    @PostMapping
    public ResponseEntity<SkinDto> createSkin(@RequestBody SkinDto skinDto) {
        return ResponseEntity.ok(skinService.createSkin(skinDto));
    }
}