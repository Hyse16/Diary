package com.project.Diary.service;

import com.project.Diary.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;
}
