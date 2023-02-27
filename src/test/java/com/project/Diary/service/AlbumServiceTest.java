package com.project.Diary.service;

import com.project.Diary.domain.Album;
import com.project.Diary.domain.Photo;
import com.project.Diary.dto.AlbumDto;
import com.project.Diary.repository.AlbumRepository;
import com.project.Diary.repository.PhotoRepository;
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

    @Autowired
    PhotoRepository photoRepository;

    @Test
    public void getAlbumTest() {
        Album album = Album.builder()
                .albumName("test")
                .build();

        albumRepository.save(album);

        AlbumDto findAlbum = albumService.getAlbumId(album.getAlbumId());
        assertEquals("test", findAlbum.getAlbumName());
    }


    @Test
    public void getAlbumNameTest() {
        Album album = Album.builder()
                .albumName("test2")
                .build();

        albumRepository.save(album);

        AlbumDto res = albumService.getAlbumName(album.getAlbumName());
        assertEquals("test1",res.getAlbumName());
    }

    @Test
    public void PhotoCountTest() {
        Album album = Album.builder()
                .albumName("test")
                .build();
        Album savedAlbum = albumRepository.save(album);


        Photo photo = Photo.builder()
                .fileName("testPhotoName1")
                .album(savedAlbum)
                .build();
        photoRepository.save(photo);


        Photo photo2 = Photo.builder()
                .fileName("testPhotoName2")
                .album(savedAlbum)
                .build();

        photoRepository.save(photo2);


        int count = photoRepository.countByAlbum_AlbumId(savedAlbum.getAlbumId());
        assertEquals(2, count);


    }
}