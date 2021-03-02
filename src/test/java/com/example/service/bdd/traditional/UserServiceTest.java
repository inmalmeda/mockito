package com.example.service.bdd.traditional;

import com.example.dao.UserDAO;
import com.example.domain.User;
import com.example.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    //captors

    //mocks
    @Mock
    UserDAO userDAO;

    //SUT
    @InjectMocks
    UserService userService;


    @Test
    @DisplayName("Test name")
    public void testName() {

        //Preparar escenario test - configuracion mocks
        Instant accessDate = Instant.now();

        when(userDAO.findOne(ArgumentMatchers.anyLong())).thenReturn(
                new User(1L, "Joaquin",accessDate)
        );

        User user = userService.findOne(1L);

        verify(userDAO,times(1)).findOne(anyLong());
        assertNotEquals(accessDate,user.getAccessDate());

    }

}
