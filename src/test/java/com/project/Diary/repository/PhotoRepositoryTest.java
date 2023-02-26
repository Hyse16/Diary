package com.project.Diary.repository;

import com.project.Diary.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PhotoRepositoryTest {

    @Autowired
    PhotoRepository photoRepository;

    @Autowired
    PhotoService photoService;


}