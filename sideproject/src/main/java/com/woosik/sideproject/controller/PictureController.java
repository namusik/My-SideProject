package com.woosik.sideproject.controller;

import com.woosik.sideproject.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pictures")
public class PictureController{

    private final PictureService pictureService;
    @GetMapping("/add")
    public String addForm() {
        return "picture/addForm";
    }

    @PostMapping("/add")
    public String uploadPicture() {

        return "members/{memberId}";
    }

}
