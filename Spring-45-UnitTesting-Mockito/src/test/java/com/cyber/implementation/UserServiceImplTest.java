package com.cyber.implementation;

import com.cyber.mapper.MapperUtil;
import com.cyber.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    MapperUtil mapperUtil;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByUserName() {
        userService.deleteByUserName("danny@danny.com");
        verify(userRepository).deleteByUserName("danny@danny.com");
    }
}