package com.project.Diary.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PhotoDto {

    Long photoId;
    String photoName;
    LocalDateTime createdAt;
}
