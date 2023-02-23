package com.project.Diary.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photo_id", unique = true, nullable = false)
    private Long photoId;

    @Column(name = "file_name", unique = false, nullable = true)
    private String fileName;

    @Column(name = "file_size", unique = false, nullable = true)
    private int fileSize;

    @Column(name = "original_url", unique = false, nullable = true)
    private String originalUrl;

    @Column(name = "thumb_url", unique = false, nullable = true)
    private String thumbUrl;

    @Column(name = "uploaded_at", unique = false, nullable = true)
    private LocalDateTime uploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;




    @Builder
    public Photo(Long photoId, String fileName, int fileSize, String originalUrl, String thumbUrl, LocalDateTime uploadedAt, Album album) {

        this.photoId = photoId;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.originalUrl = originalUrl;
        this.thumbUrl = thumbUrl;
        this.uploadedAt = uploadedAt;
        this.album = album;
    }
}
