package com.project.Diary.service;

import com.project.Diary.domain.Album;
import com.project.Diary.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AlbumServiceTest {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;

    @Test
    public void getAlbumTest() {
        Album album = Album.builder()
                .albumName("test")
                .build();

        albumRepository.save(album);

        Album findAlbum = albumService.getAlbumId(album.getAlbumId());
        assertEquals("test", findAlbum.getAlbumName());
    }


    @Test
    public void getAlbumNameTest() {
        Album album = Album.builder()
                .albumName("test2")
                .build();

        albumRepository.save(album);

        Album res = albumService.getAlbumName(album.getAlbumName());
        assertEquals("test1",res.getAlbumName());
    }
}