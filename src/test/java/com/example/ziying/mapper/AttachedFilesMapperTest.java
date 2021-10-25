package com.example.ziying.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AttachedFilesMapperTest {

    @Resource
    private AttachedFilesMapper attachedFilesMapper;

    @Test
    void selectAttachedFiles() {
        System.out.println(attachedFilesMapper.selectAttachedFiles());
    }
}