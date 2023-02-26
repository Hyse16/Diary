package com.project.Diary.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "album")
@Getter
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album", unique = true, nullable = false)
    private Long albumId;

    @Column(name = "album_name", unique = false, nullable = true)
    private String albumName;


    @Column(name = "created_at", unique = false, nullable = true)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album", cascade = CascadeType.ALL)
    private List<Photo> photoList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @Builder
    public Album(Long albumId, String albumName, LocalDateTime createdAt, Member member, List<Photo> photoList) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.createdAt = createdAt;
        this.photoList = photoList;
        this.member = member;

    }
}
