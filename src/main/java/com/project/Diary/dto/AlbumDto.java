package com.project.Diary.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Data
public class AlbumDto {

    private Long albumId;

    @NotBlank(message = "앨범이름은 필수 입니다.")
    private String albumName;

    private LocalDateTime createdAt;

    private int count;
}
