package com.woosik.sideproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String camera;
    private String lens;
    private int iso;
    private double aperture;
    private int shutterSpeed;
    private int focalLength;
    private String latitude;
    private String longitude;
    private Long size;
}
