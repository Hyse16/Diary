package com.project.Diary.service;

import com.project.Diary.domain.Album;
import com.project.Diary.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    public Album getAlbumId(Long albumId) {
        Optional<Album> res = albumRepository.findById(albumId);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new EntityNotFoundException(String.format("앨범아이디 %d로 조회되지 않습니다", albumId));
        }
    }

    public Album getAlbumName(String albumName) {
        Optional<Album> findAlbumName = albumRepository.findByAlbumName(albumName);
        if (findAlbumName.isPresent()) {
            return findAlbumName.get();
        } else {
            throw new EntityNotFoundException(String.format("앨범이름 %s로 조회되지 않습니다", albumName));
        }
    }
}
