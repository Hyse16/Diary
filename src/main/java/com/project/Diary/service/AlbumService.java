package com.project.Diary.service;

import com.project.Diary.domain.Album;
import com.project.Diary.dto.AlbumDto;
import com.project.Diary.mapper.AlbumMapper;
import com.project.Diary.repository.AlbumRepository;
import com.project.Diary.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    PhotoRepository photoRepository;

    public AlbumDto getAlbumId(Long albumId) {
        Optional<Album> res = albumRepository.findById(albumId);
        if (res.isPresent()) {
            AlbumDto albumDto = AlbumMapper.convertToDto(res.get());
            albumDto.setCount(photoRepository.countByAlbum_AlbumId(albumId));
            return albumDto;
        } else {
            throw new EntityNotFoundException(String.format("앨범아이디 %d로 조회되지 않습니다", albumId));
        }
    }

    public AlbumDto getAlbumName(String albumName) {
        Optional<Album> findAlbumName = albumRepository.findByAlbumName(albumName);
        if (findAlbumName.isPresent()) {
            AlbumDto albumDto = AlbumMapper.convertToDto(findAlbumName.get());
            albumDto.setCount(photoRepository.countByAlbum_AlbumId(findAlbumName.get().getAlbumId()));
            return albumDto;
        } else {
            throw new EntityNotFoundException(String.format("앨범이름 %s로 조회되지 않습니다", albumName));
        }
    }
}
