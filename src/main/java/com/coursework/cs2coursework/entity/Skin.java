package com.coursework.cs2coursework.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String rarity;

    @Column(nullable = false)
    private String imageUrl;
}