package com.woosik.sideproject.dto;

import lombok.Data;

@Data
public class PictureSaveDto {
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
