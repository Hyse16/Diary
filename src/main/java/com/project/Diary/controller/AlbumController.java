package com.project.Diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AlbumController {

    @GetMapping(value = "/album")
    public String albumForm() {
        return "album/  albumForm.html";
    }
}
